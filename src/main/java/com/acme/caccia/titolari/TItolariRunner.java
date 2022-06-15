package com.acme.caccia.titolari;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class TItolariRunner implements ApplicationRunner{
	
	@Autowired
	TitolareRepository titolareRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker fk = new Faker(new Locale("it-IT"));
		
		for (int i=0; i<30;i++) {
			Titolare t = new Titolare();
			t.setNome(fk.name().firstName());
			t.setCognome(fk.name().lastName());
			
			titolareRepo.save(t);
		}
		
		Optional<Titolare> optTitolare = titolareRepo.findById(20l);
		if (optTitolare.isPresent()) {
			System.out.println("Titolare: " + optTitolare);
		} else {
			System.out.println("Titolare non presente.");
		}
		
		titolareRepo.deleteById(15l);
		titolareRepo.findByName("Giulio");
	}

}
