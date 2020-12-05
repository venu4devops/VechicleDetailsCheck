package pojos;

import io.cucumber.java.tr.Ve;

import java.util.Objects;

public class Vehicle {
    private String registrationNumber;
    private String make;
    private String model;
    private String colour;
    private String year;

    public Vehicle(String vehicleDetail) {
        String[] details = vehicleDetail.split(",");
        this.registrationNumber = details[0];
        this.make = details[1];
        this.model = details[2];
        this.colour = details[3];
        this.year = details[4];
    }

    public Vehicle(String registrationNumber, String make, String model, String colour, String year) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return registrationNumber.contentEquals(vehicle.getRegistrationNumber())
                && make.contentEquals(vehicle.getMake())
                && model.contentEquals(vehicle.getModel())
                && colour.contentEquals(vehicle.getColour())
                && year.contentEquals(vehicle.getYear());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
