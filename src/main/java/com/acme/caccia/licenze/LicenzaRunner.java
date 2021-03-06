package com.acme.caccia.licenze;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acme.caccia.citta.CittaRunner;
import com.acme.caccia.titolari.Titolare;
import com.acme.caccia.titolari.TitolareRepository;
import com.acme.caccia.titolari.TitolareRunner;
import com.github.javafaker.Faker;

@Component
@Order(3)
public class LicenzaRunner implements ApplicationRunner {
	@Autowired
	LicenzaRepository licenzaRepo;

	@Autowired
	TitolareRepository titolareRepo;

	public static int NUMERO_LICENZE = 30;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Faker fk = new Faker(new Locale ("it-IT"));
		
		System.out.println("========Runner Licenze Partito===========");
		for (int i=0; i<NUMERO_LICENZE;i++) {
			Licenza l = new Licenza();
			l.setAtc(fk.address().cityName());
			l.setNumeroSerieArma(fk.number().digits(10));
			l.setTipologiaPreda(fk.pokemon().name());
			l.setAnnoScadenza(fk.number().numberBetween(2020, 2025));
			l.setNumeroLicenza(fk.number().digits(5));
			Optional<Titolare> optTitolare=titolareRepo.findById(
					Long.valueOf(fk.number().numberBetween
							(1, TitolareRunner.NUMERO_TITOLARI)));
			if(optTitolare.isPresent()) {
				l.setTitolare(optTitolare.get());
			}
			licenzaRepo.save(l);
		
	}

}
}