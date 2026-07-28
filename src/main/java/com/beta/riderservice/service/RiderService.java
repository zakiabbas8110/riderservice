package com.beta.riderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.riderservice.dto.RiderRegisterdto;
import com.beta.riderservice.dto.RiderResponse;
import com.beta.riderservice.entity.Rider;
import com.beta.riderservice.entity.Vehicle;
import com.beta.riderservice.repositary.RiderRepository;


@Service
public class RiderService {

    @Autowired
    private RiderRepository ridrep;

    public RiderResponse rideRegister(RiderRegisterdto ridereg) {

       
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(ridereg.getVehicleNumber());
        vehicle.setVehicleType(ridereg.getVehicleType());
        vehicle.setVehicleModel(ridereg.getVehicleModel());
        vehicle.setVehicleColor(ridereg.getVehicleColor());
        vehicle.setSeatingCapacity(ridereg.getSeatingCapacity());

  
        Rider newrid = new Rider();
        newrid.setName(ridereg.getName());
        newrid.setPhone(ridereg.getPhone());
        newrid.setEmail(ridereg.getEmail());
        newrid.setWalletBalance(ridereg.getWalletBalance());
        newrid.setDrivingLicenseNumber(ridereg.getDrivingLicenseNumber());
        newrid.setStatus(ridereg.getStatus());

        
        newrid.setVehicle(vehicle);

        
        Rider savedRider = ridrep.save(newrid);

        RiderResponse response = new RiderResponse();

        response.setRiderId(savedRider.getRiderId());
        response.setName(savedRider.getName());
        response.setPhone(savedRider.getPhone());
        response.setEmail(savedRider.getEmail());
        response.setWalletBalance(savedRider.getWalletBalance());
        response.setDrivingLicenseNumber(savedRider.getDrivingLicenseNumber());
        response.setStatus(savedRider.getStatus());

        response.setVehicleNumber(savedRider.getVehicle().getVehicleNumber());
        response.setVehicleType(savedRider.getVehicle().getVehicleType());
        response.setVehicleModel(savedRider.getVehicle().getVehicleModel());
        response.setVehicleColor(savedRider.getVehicle().getVehicleColor());
        response.setSeatingCapacity(savedRider.getVehicle().getSeatingCapacity());

        return response;
    }
    
    
}
