package com.Drivein.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Drivein.www.dto.CounterDto;
import com.Drivein.www.dto.ItemsDto;
import com.Drivein.www.model.Login;
import com.Drivein.www.service.CounterService;


@CrossOrigin("*")
@RestController
public class CounterController {
	@Autowired
	private CounterService serv;
	
	@PostMapping("/addcounters")
	public ResponseEntity<String> add(@RequestBody CounterDto dto)
	{
		return serv.add(dto);
	}
	
	@GetMapping("/fetchcounters")
	public ResponseEntity<?> get()
	{
		return serv.get();
	}
	
	@GetMapping("/fetchcounter")
	public ResponseEntity<?> getcounteritems(@RequestParam Long id)
	{
		return serv.getcounteritems(id);
	}
	 
	@PutMapping("/updatecounters/{id}")
	public ResponseEntity<String> update(@PathVariable Long id,@RequestBody CounterDto dto)
	{
		return serv.update(id,dto);
	}

	@DeleteMapping("/deletecounters/{id}")
	public ResponseEntity<String> delete(@PathVariable long id)
	{
		return serv.delete(id);
	}
	
	@PostMapping("/additems")
	public  ResponseEntity<String> additems(@RequestBody ItemsDto dto)
	{
		return serv.additems(dto);
	}
	@GetMapping("/fetchitems")
	public ResponseEntity<?> getitems()
	{
		return serv.getitems();
	}

	@PutMapping("/updateiteems/{id}")
	public ResponseEntity<String> updateitems(@PathVariable Long id,@RequestBody CounterDto dto)
	{
		return serv.updateitems(id,dto);
	}
	@DeleteMapping("/deleteitems/{id}")
	public ResponseEntity<String> deleteitems(@PathVariable long id)
	{
		return serv.deleteitems(id);
	}
	@PostMapping("/login")
	public  ResponseEntity<String> addlogin(@RequestBody Login login)
	{
		return serv.addLogin(login);
	}
}
