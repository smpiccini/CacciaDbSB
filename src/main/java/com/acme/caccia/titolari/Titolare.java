package com.acme.caccia.titolari;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.acme.caccia.citta.Citta;
import com.acme.caccia.licenze.Licenza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "titolari")
public class Titolare {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=30, nullable = false)
	private String nome;
	@Column(length=30, nullable = false)
	private String cognome;
	
	@ManyToOne
	private Citta citta;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "titolare")
	private List<Licenza> licenze;

}
