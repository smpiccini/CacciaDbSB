package com.acme.caccia.tesserini;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.acme.caccia.licenze.Licenza;
import com.acme.caccia.licenze.LicenzaRepository;
import com.acme.caccia.licenze.LicenzaRunner;
import com.acme.caccia.titolari.Titolare;
import com.acme.caccia.titolari.TitolareRunner;
import com.github.javafaker.Faker;

@Component
public class TesserinoRunner implements ApplicationRunner {

	@Autowired
	TesserinoRepository tesserinoRepo;
	@Autowired
	LicenzaRepository licenzaRepo;
	
	public static int NUMERO_TESSERINI = 50;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker fk=new Faker (new Locale ("it-IT"));
		System.out.println("========Runner Tesserini Partito===========");
		for (int i=0; i<NUMERO_TESSERINI;i++) {
			Tesserino ts= new Tesserino();
			ts.setAnnoScadenza(fk.number().numberBetween(2020, 2025));
			Optional<Licenza> optLicenza=licenzaRepo.findById(
					Long.valueOf(fk.number().numberBetween
							(1, LicenzaRunner.NUMERO_LICENZE)));
			if(optLicenza.isPresent()) {
				ts.setLicenza(optLicenza.get());
				
			}
			tesserinoRepo.save(ts);
		}
		int from = 2020;
		int to = 2022;
		System.out.println("Tesserini tra gli anni " + from + " a " + to);
		List<Tesserino> tesserini = tesserinoRepo.
				findByAnnoScadenzaBetween(from, to);
		for (Tesserino t : tesserini) {
			System.out.println(t);
		}
	}

}
