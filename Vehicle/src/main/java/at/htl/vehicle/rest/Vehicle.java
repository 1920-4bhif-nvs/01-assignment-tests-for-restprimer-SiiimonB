package at.htl.vehicle.rest;

public class Vehicle {

    private String type;
    private String brand;

    public Vehicle(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
