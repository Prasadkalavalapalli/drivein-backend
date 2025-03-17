package com.Drivein.www.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="paymenthistory")
@Data
public class Payments {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private  String customername;
	private double amount;
	private String billno;
	
	@ManyToOne
	@JoinColumn(name="counter_id")
	private Counters counter;
}
