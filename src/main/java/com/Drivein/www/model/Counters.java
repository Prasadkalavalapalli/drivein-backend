package com.Drivein.www.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="counter")
public class Counters {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner; 
    private String status;
    private String contact;
    private String email;
    private String image;
    
    @OneToMany(mappedBy = "counter")
    @JsonManagedReference
    private List<Items> items;
    @OneToMany(mappedBy="counter")
    private List<Payments> payments;
}
