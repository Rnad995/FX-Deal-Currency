package com.bloomberg.fxdeal.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "request", schema = "bloomberg")
public class Request {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;
	 @Column(name = "fromIso")
	 String fromIso;
	 
	 @Column(name = "toIso")
	 String toIso;
	 
	 @Column(name = "date")
	 private LocalDateTime date;
	 
	 @Column(name = "amount")
	 BigDecimal amount;
	 
	
	public Request() {
		super();
	}


	public Request(String fromIso, String toIso, LocalDateTime date, BigDecimal amount) {
		super();
		this.fromIso = fromIso;
		this.toIso = toIso;
		this.date = date;
		this.amount = amount;
	}


	public String getfromIso() {
		return fromIso;
	}


	public void setfromIso(String fromIso) {
		this.fromIso = fromIso;
	}


	public String gettoIso() {
		return toIso;
	}


	public void settoIso(String toIso) {
		this.toIso = toIso;
	}


	public LocalDateTime getDeal_timestamp() {
		return date;
	}


	public void setDeal_timestamp(LocalDateTime date) {
		this.date = date;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Request [fromIso=" + fromIso + ", toIso=" + toIso + ", date=" + date
				+ ", amount=" + amount + "]";
	}
	 
	 

}
