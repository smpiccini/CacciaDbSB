package com.acme.caccia.citta;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
@Order(1)
public class CittaRunner implements ApplicationRunner{

	@Autowired
	CittaRepository cittaRepo;
	
	private static int NUMERO_CITTA = 10;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Faker fk = new Faker(new Locale("it-IT"));
		
		for (int i=0; i<NUMERO_CITTA;i++) {
			Citta c = new Citta();
			c.setCitta(fk.address().cityName());
			c.setProvincia(fk.address().country());
			
			cittaRepo.save(c);
		}
	}
	

}
