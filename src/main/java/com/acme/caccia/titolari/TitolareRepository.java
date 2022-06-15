package com.acme.caccia.titolari;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitolareRepository 
	extends PagingAndSortingRepository<Titolare, Long>{
	
	public List<Titolare> findByName(String n);
	
	@Transactional
	public List<Titolare> findByNomeContainingIgnoreCase(String n);
	public List<Titolare> findByNomeStartingWithIgnoreCaseAndCognomeContainingIgnoreCase(String n, String c);
}