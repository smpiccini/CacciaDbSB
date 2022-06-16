package com.acme.caccia.tesserini;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.acme.caccia.licenze.Licenza;
import com.acme.caccia.licenze.LicenzaRepository;
import com.acme.caccia.titolari.Titolare;
import com.github.javafaker.Faker;

@Component
public class TesserinoRunner implements ApplicationRunner {

	@Autowired
	TesserinoRepository tesserinoRepo;
	@Autowired
	LicenzaRepository licenzaRepo;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker fk=new Faker (new Locale ("it-IT"));
		System.out.println("========Runner Partito===========");
		for (int i=0; i<30;i++) {
			Tesserino ts= new Tesserino();
			ts.setAnnoScadenza(fk.number().numberBetween(2020, 2025));
			Optional<Licenza> optLicenza=licenzaRepo.findById(Long.valueOf(i));
			if(optLicenza.isPresent()) {
				ts.setLicenza(optLicenza.get());
				
			}
			tesserinoRepo.save(ts);
		}
			
	}

}
