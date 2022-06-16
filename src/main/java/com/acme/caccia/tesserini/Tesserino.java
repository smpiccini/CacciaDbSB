package com.acme.caccia.tesserini;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.acme.caccia.licenze.Licenza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name= "tesserini")
public class Tesserino {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private int annoScadenza;
		
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="licenza_id")
	private Licenza licenza;

}
