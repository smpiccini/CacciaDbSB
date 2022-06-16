package com.acme.caccia.licenze;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.ManyToAny;

import com.acme.caccia.tesserini.Tesserino;
import com.acme.caccia.titolari.Titolare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name="licenze")
public class Licenza {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(length=50, nullable = false)
	private String atc;
	@Column(length=50, nullable = false)
	private String numeroSerieArma;
	@Column(length=50, nullable = false)
	private String tipologiaPreda;
	
	@Column(nullable = false)
	private int annoScadenza;
	
	@Column(length=50, nullable = false)
	private String numeroLicenza;
		
	
	@ToStringExclude
	@ManyToOne
	private Titolare titolare; 
	
	
	@OneToMany(mappedBy = "licenza")
	private List<Tesserino> tesserini;
	
	
}
