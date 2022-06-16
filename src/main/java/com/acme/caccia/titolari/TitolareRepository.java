package com.acme.caccia.titolari;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitolareRepository 
	extends PagingAndSortingRepository<Titolare, Long>{
	
	@Transactional
	public List<Titolare> findByCognomeStartingWithIgnoreCase(String cognome);
	}

