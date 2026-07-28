package com.beta.riderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.riderservice.dto.RiderRegisterdto;
import com.beta.riderservice.dto.RiderResponse;
import com.beta.riderservice.dto.RiderStatusResponse;
import com.beta.riderservice.entity.Rider;
import com.beta.riderservice.entity.Vehicle;
import com.beta.riderservice.exception.RiderAlreadyExistsException;
import com.beta.riderservice.exception.RiderNotFoundException;
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

  
        if (ridrep.existsByEmail(ridereg.getEmail())) {
            throw new RiderAlreadyExistsException("Email already exists");
        }

        if (ridrep.existsByPhone(ridereg.getPhone())) {
            throw new RiderAlreadyExistsException("Phone number already exists");
        }

        
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
    
    public RiderResponse getRiderById(int riderId) {

        Rider rider = ridrep.findById(riderId)
                .orElseThrow(() ->
                        new RiderNotFoundException("Rider not found with ID : " + riderId));

        RiderResponse response = new RiderResponse();

        response.setRiderId(rider.getRiderId());
        response.setName(rider.getName());
        response.setPhone(rider.getPhone());
        response.setEmail(rider.getEmail());

        return response;
    }
    
    public List<RiderResponse> getAllRiders() {

        List<Rider> riders = ridrep.findAll();

        List<RiderResponse> responseList = new ArrayList<>();

        for (Rider rider : riders) {

            RiderResponse response = new RiderResponse();

            response.setRiderId(rider.getRiderId());
            response.setName(rider.getName());
            response.setPhone(rider.getPhone());
            response.setEmail(rider.getEmail());
            response.setWalletBalance(rider.getWalletBalance());
            response.setDrivingLicenseNumber(rider.getDrivingLicenseNumber());
            response.setStatus(rider.getStatus());

            if (rider.getVehicle() != null) {
                response.setVehicleNumber(rider.getVehicle().getVehicleNumber());
                response.setVehicleType(rider.getVehicle().getVehicleType());
                response.setVehicleModel(rider.getVehicle().getVehicleModel());
                response.setVehicleColor(rider.getVehicle().getVehicleColor());
                response.setSeatingCapacity(rider.getVehicle().getSeatingCapacity());
            }

            responseList.add(response);
        }

        return responseList;
    }
    
    public RiderResponse updateRider(int id, RiderRegisterdto dto) {

        Rider rider = ridrep.findById(id)
                .orElseThrow(() ->
                        new RiderNotFoundException("Rider not found with ID : " + id));

        rider.setName(dto.getName());
        rider.setPhone(dto.getPhone());
        rider.setEmail(dto.getEmail());
        rider.setWalletBalance(dto.getWalletBalance());
        rider.setDrivingLicenseNumber(dto.getDrivingLicenseNumber());
        rider.setStatus(dto.getStatus());

        Vehicle vehicle = rider.getVehicle();

        if (vehicle != null) {
            vehicle.setVehicleNumber(dto.getVehicleNumber());
            vehicle.setVehicleType(dto.getVehicleType());
            vehicle.setVehicleModel(dto.getVehicleModel());
            vehicle.setVehicleColor(dto.getVehicleColor());
            vehicle.setSeatingCapacity(dto.getSeatingCapacity());
        }

        Rider updatedRider = ridrep.save(rider);

        RiderResponse response = new RiderResponse();

        response.setRiderId(updatedRider.getRiderId());
        response.setName(updatedRider.getName());
        response.setPhone(updatedRider.getPhone());
        response.setEmail(updatedRider.getEmail());
        response.setWalletBalance(updatedRider.getWalletBalance());
        response.setDrivingLicenseNumber(updatedRider.getDrivingLicenseNumber());
        response.setStatus(updatedRider.getStatus());

        if (updatedRider.getVehicle() != null) {
            response.setVehicleNumber(updatedRider.getVehicle().getVehicleNumber());
            response.setVehicleType(updatedRider.getVehicle().getVehicleType());
            response.setVehicleModel(updatedRider.getVehicle().getVehicleModel());
            response.setVehicleColor(updatedRider.getVehicle().getVehicleColor());
            response.setSeatingCapacity(updatedRider.getVehicle().getSeatingCapacity());
        }

        return response;
    }
    
    public void deleteRider(int id) {

        Rider rider = ridrep.findById(id)
                .orElseThrow(() ->
                        new RiderNotFoundException("Rider not found with ID : " + id));

        ridrep.delete(rider);
    }
    
    public RiderStatusResponse toggleRiderStatus(int id) {

        Rider rider = ridrep.findById(id)
                .orElseThrow(() ->
                    new RiderNotFoundException("Rider not found with ID : " + id));

        if (rider.getStatus().equalsIgnoreCase("AVAILABLE")) {
            rider.setStatus("OFFLINE");
        } else {
            rider.setStatus("AVAILABLE");
        }

        Rider updatedRider = ridrep.save(rider);

        RiderStatusResponse response = new RiderStatusResponse();

        response.setRiderId(updatedRider.getRiderId());
        response.setName(updatedRider.getName());
        response.setStatus(updatedRider.getStatus());

        return response;
    }
    
    
}
