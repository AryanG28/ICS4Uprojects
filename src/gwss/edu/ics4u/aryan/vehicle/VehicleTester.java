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
public class VehicleTester {
    public static void main (String [] args) {
        Car bugatti = new Car();
        bugatti.setHasGas(true);
        bugatti.setNumOfCylinders(8);
        bugatti.setNumOfDoors(2);
        bugatti.setVehicleBrand("Bugatti Veyron");
        bugatti.setPowerType("Plutonium");
        
        Bicycle bike = new Bicycle();
        bike.setBikeType("Racing");
        bike.setIsOperatable(true);
        bike.setCanDoWheelies(true);
        bike.setNumOfWheels(2);
        
        System.out.println("POLYMORPHISM METHODS");
        System.out.println("- Moving Car");
        bugatti.move();
        
        System.out.println("- Moving Bike");
        bike.move();
        
        System.out.println("- Speeding up");
        bugatti.speedUp();
        bike.speedUp();
        
        System.out.println("- Braking");
        bugatti.brake();
        bike.brake();
        
        System.out.println("- Slowing down");
        bugatti.slowDown();
        bike.slowDown();
        System.out.println("_________________");
        
        System.out.println("ALL CAR METHODS");
        System.out.println("- Changing Oil");
        bugatti.oilChange();
        System.out.println("- Turning On");
        bugatti.turnOn();
        System.out.println("- Turning Off");
        bugatti.turnOff();
        System.out.println("_________________");
        
        System.out.println("ALL BIKE METHODS");
        System.out.println("- Changing Bike Chain");
        bike.changeBikeChain();
        System.out.println("- Front Brake");
        bike.frontBrake();
        System.out.println("- Back brake");
        bike.backBrake();
        System.out.println("_________________");
        
    }
}
