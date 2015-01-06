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
public abstract class Vehicle implements VehicleInterface {

    int numOfWheels;
    boolean isOperatable;
    double price;
    int topSpeed;

    public Vehicle() {

    }

    public Vehicle(int numOfWheels, boolean isOperatable, double price, int topSpeed) {
        this.setIsOperatable(isOperatable);
        this.setNumOfWheels(numOfWheels);
        this.setIsOperatable(isOperatable);
        this.setTopSpeed(topSpeed);
    }

    @Override
    public void move() {
        System.out.println("Vehicle is now in motion");
    }

    @Override
    public void speedUp() {
        System.out.println("Vehicle is speeding up");
    }

    @Override
    public void slowDown() {
        System.out.println("Vehicle is slowing down");
    }

    @Override
    public void brake() {
        System.out.println("Vehicle is braking");
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        if (this.topSpeed > 0) {
            this.topSpeed = topSpeed;
        }
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public void setNumOfWheels(int numOfWheels) {
        if (numOfWheels > 0) {
            this.numOfWheels = numOfWheels;
        }
    }

    public boolean isIsOperatable() {
        return isOperatable;
    }

    public void setIsOperatable(boolean isOperatable) {
        this.isOperatable = isOperatable;
    }

}
