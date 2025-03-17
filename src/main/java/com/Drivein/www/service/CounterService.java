package com.Drivein.www.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Drivein.www.dto.CounterDto;
import com.Drivein.www.dto.ItemsDto;
import com.Drivein.www.model.Counters;
import com.Drivein.www.model.Items;
import com.Drivein.www.model.Login;
import com.Drivein.www.repo.CounterRepo;
import com.Drivein.www.repo.ItemsRepo;
import com.Drivein.www.repo.LoginRepo;

@Service
public class CounterService {

	@Autowired
	CounterRepo repo;
	@Autowired
	ItemsRepo itemrepo;
	@Autowired 
	ModelMapper mp;
	@Autowired 
	LoginRepo loginrepo;
	
	public ResponseEntity<String> add(CounterDto dto) {
		Counters con =new Counters();
		con=mp.map(dto,Counters.class);
		repo.save(con);
		return ResponseEntity.status(200).body("data saved successfully");
	}

	public ResponseEntity<?> get() {
		List<Counters> coun=repo.findAll();
		return ResponseEntity.status(200).body(coun);
	}
	
	public ResponseEntity<String> delete(Long id)
	{
		repo.deleteById(id);
		return ResponseEntity.status(200).body("Record deleted");
	}

	public ResponseEntity<String> update(Long id, CounterDto dto) {
	    Optional<Counters> counter = repo.findById(id);
	    
	    if (counter.isPresent()) {
	        Counters coun = counter.get(); // Get the Employee object from Optional
	        
	        // Map updated fields from DTO to existing employee object
	        coun= mp.map(dto, Counters.class);
	        coun.setId(id); // Ensure the ID remains unchanged

	        repo.save(coun); // Save updated employee

	        return ResponseEntity.status(200).body("Record updated successfully");
	    } else {
	        return ResponseEntity.status(404).body("counter not found");
	    }
	}

	public ResponseEntity<String> additems(ItemsDto dto) {
		Items con =new Items();
		con=mp.map(dto,Items.class);
		con.setCounter(dto.getCounter());
		itemrepo.save(con);
		return ResponseEntity.status(200).body("data saved successfully");
	}

	public ResponseEntity<?> getitems() {
		List<Items> coun=itemrepo.findAll();
		return ResponseEntity.status(200).body(coun);
	}

	public ResponseEntity<String> updateitems(Long id, CounterDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<String> deleteitems(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> getcounteritems(Long id) {
		Optional <Counters> counteritems=repo.findById(id);
		return ResponseEntity.status(200).body(counteritems);
	}

	public ResponseEntity<String> addLogin(Login login) 
	{
        Login log = loginrepo.findByUsername(login.getUsername()); 

        if (log != null) {
            if (log.getPassword().equals(login.getPassword())) 
            {
                return ResponseEntity.status(200).body("Access Granted");
            } else {
                return ResponseEntity.status(403).body("Password not matched..!");
            }
        } else {
            return ResponseEntity.status(404).body("Wrong username or not registered");
        }
    }
}
