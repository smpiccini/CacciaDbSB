package com.acme.caccia.titolari;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acme.caccia.citta.Citta;
import com.acme.caccia.citta.CittaRepository;
import com.github.javafaker.Faker;

@Component
@Order(2)  //quando va a eseguire i runner questo è il primo che eseguo
public class TitolareRunner implements ApplicationRunner{
	
	@Autowired
	TitolareRepository titolareRepo;
	@Autowired
	CittaRepository cittaRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker fk = new Faker(new Locale("it-IT"));
		
		System.out.println("========Runner Partito===========");
		for (int i=0; i<30;i++) {
			Titolare t = new Titolare();
			t.setNome(fk.name().firstName());
			t.setCognome(fk.name().lastName());
			Optional<Citta> optCitta=cittaRepo.findById(Long.valueOf(i));
			if(optCitta.isPresent()) {
				t.setCitta(optCitta.get());
			}
			titolareRepo.save(t);
		}
		
		
		
	

	}

}

