package com.Drivein.www.dto;

import com.Drivein.www.model.Counters;

import lombok.Data;

@Data
public class ItemsDto {

	private String name;
	private String quantity;
	private String price;
	private String status;
	 private Counters counter;
}
