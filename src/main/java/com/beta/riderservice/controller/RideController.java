package com.beta.riderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.beta.riderservice.dto.RiderRegisterdto;
import com.beta.riderservice.dto.RiderResponse;
import com.beta.riderservice.dto.RiderStatusResponse;
import com.beta.riderservice.service.RiderService;

@RestController
@RequestMapping("/rider")
public class RideController {

    @Autowired
    private RiderService ridservice;

    // Register Rider
    @PostMapping("/register")
    public RiderResponse registerNewRider(@RequestBody RiderRegisterdto riderdto) {
        return ridservice.rideRegister(riderdto);
    }

    // Get Rider By ID
    @GetMapping("/{id}")
    public RiderResponse getRiderById(@PathVariable int id) {
        return ridservice.getRiderById(id);
    }

    // Get All Riders
    @GetMapping("/all")
    public List<RiderResponse> getAllRiders() {
        return ridservice.getAllRiders();
    }

    // Update Rider
    @PutMapping("/update/{id}")
    public RiderResponse updateRider(@PathVariable int id,
                                     @RequestBody RiderRegisterdto riderdto) {
        return ridservice.updateRider(id, riderdto);
    }

    // Delete Rider
    @DeleteMapping("/delete/{id}")
    public String deleteRider(@PathVariable int id) {
        ridservice.deleteRider(id);
        return "Rider deleted successfully";
    }
    
    @PatchMapping("/status/{id}")
    public RiderStatusResponse toggleRiderStatus(@PathVariable int id) {
        return ridservice.toggleRiderStatus(id);
    }
}