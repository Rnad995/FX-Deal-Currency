package com.bloomberg.fxdeal.model;


import jakarta.persistence.*;

@Entity
@Table(name = "currency", schema = "bloomberg")
public class Currency {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

	 @Column(name = "name")
	 String name;

	 double value;

	public Currency() {
	}

	public Currency(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	


	 
	
}
