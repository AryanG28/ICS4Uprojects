/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.vehicle;

/**
 *
 * @author Aryan
 */
public class Car extends Vehicle {

    int numOfCylinders;
    String vehicleBrand;
    int numOfDoors;
    boolean hasGas;
    boolean isOn;
    String powerType;

    public Car(int numOfCylinders, String vehicleBrand, int numOfDoors, boolean hasGas, boolean isOn, String powerType) {
        super();
        this.setNumOfCylinders(numOfCylinders);
        this.setVehicleBrand(vehicleBrand);
        this.setNumOfDoors(numOfDoors);
        this.setHasGas(hasGas);
        this.setIsOn(isOn);
        this.setPowerType(powerType);
    }

    public Car() {
        this.isOn = true;
        System.out.println("Car created");
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void speedUp() {
        super.speedUp();
    }

    @Override
    public void slowDown() {
        super.slowDown();
    }

    @Override
    public void brake() {
        super.brake();
    }

    public void turnOn() {
        this.isOn = false;
        System.out.println("Car is now on");
    }

    public void turnOff() {
        System.out.println("Car is now off");
    }

    public void oilChange() {
        System.out.println("Oil is now fresh");
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public int getNumOfCylinders() {
        return this.numOfCylinders;
    }

    public void setNumOfCylinders(int numOfCylinders) {
        this.numOfCylinders = numOfCylinders;
    }

    public String getVehicleBrand() {
        return this.vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public int getNumOfDoors() {
        return this.numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public boolean isHasGas() {
        return this.hasGas;
    }

    public void setHasGas(boolean hasGas) {
        this.hasGas = hasGas;
    }

}
