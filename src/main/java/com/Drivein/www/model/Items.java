package com.Drivein.www.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table()
public class Items {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private int quantity;  // Changed to int
    private double price;  // Changed to double
    private String status;

    @ManyToOne
    @JoinColumn(name = "counter_id", nullable = false) 
    @JsonBackReference
    private Counters counter;  
}
