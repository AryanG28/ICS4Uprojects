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
public class Bicycle extends Vehicle {
 int numOfGears;
    String bikeType;
    boolean canDoWheelies;

    public Bicycle() {
        System.out.println("Bicycle created");
    }

    public Bicycle (int numOfGears, String bikeType, boolean canDoWheelies) {
        super();
        this.setNumOfGears(numOfGears);
        this.setCanDoWheelies(canDoWheelies);
        this.setBikeType(bikeType);
    }
    
    public void doWheelie() {
        if (this.canDoWheelies) {
            System.out.println("Wheeleing");
        }
    }
    
    public void changeBikeChain () {
        System.out.println("Bike chain is now clean");
    }
    
    public void frontBrake() {
        System.out.println("Front brake being applied...  Watch out harjeevan");
    }

    public void backBrake() {
        System.out.println("Back brake being applied");
    }

    public int getNumOfGears() {
        return this.numOfGears;
    }

    public void setNumOfGears(int numOfGears) {
        this.numOfGears = numOfGears;
    }

    public String getBikeType() {
        return this.bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public boolean isCanDoWheelies() {
        return this.canDoWheelies;
    }

    public void setCanDoWheelies(boolean canDoWheelies) {
        this.canDoWheelies = canDoWheelies;
    }

}
