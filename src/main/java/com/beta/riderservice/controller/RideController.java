package com.beta.riderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beta.riderservice.dto.RiderRegisterdto;
import com.beta.riderservice.service.RiderService;

@RestController
public class RideController {
	
	@Autowired
	private RiderService ridservice;
	
	@PostMapping ("/rider/register")
	public void resgisterNewrider(@RequestBody RiderRegisterdto riderdto) {
		ridservice.rideRegister(riderdto);
	}
	@GetMapping("/rider/{id}")
	public void getRider() {
		
	}

}
