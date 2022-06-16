package com.acme.caccia.tesserini;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TesserinoRepository extends PagingAndSortingRepository<Tesserino, Long> {
	public List<Tesserino> findByAnnoScadenzaBetween(int from, int to);
}
