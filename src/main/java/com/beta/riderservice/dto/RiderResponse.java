package com.beta.riderservice.dto;

public class RiderResponse {

    // Rider Details
    private Integer riderId;
    private String name;
    private Long phone;
    private String email;
    private Double walletBalance;
    private String drivingLicenseNumber;
    private String status;

    // Vehicle Details
    private String vehicleNumber;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleColor;
    private Integer seatingCapacity;

    // Default Constructor
    public RiderResponse() {
    }

    // Parameterized Constructor
    public RiderResponse(Integer riderId, String name, Long phone, String email,
                         Double walletBalance, String drivingLicenseNumber,
                         String status, String vehicleNumber, String vehicleType,
                         String vehicleModel, String vehicleColor,
                         Integer seatingCapacity) {
        this.riderId = riderId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.walletBalance = walletBalance;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.status = status;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleColor = vehicleColor;
        this.seatingCapacity = seatingCapacity;
    }

    // Getters and Setters

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
