package com.example.demo.api;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "postal_data")
@Data
public class PostalData implements Serializable {
	
	private static final long serialVersionUID = 3436476966775519918L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected long id;

	@Column(name = "suburbname")
	protected String suburbname;
	
	@Column(name = "postalcode")
	protected int postalcode;
	
}
