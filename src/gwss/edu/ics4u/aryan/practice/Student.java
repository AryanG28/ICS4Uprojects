/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.practice;

/**
 *
 * @author Aryan
 */

import java.util.Objects;

public class Student {
    private int weight;
    private static int numberCreated = 0;
    private int serialNumber;
    private double cost;
    private String wood;
    
    public Student(){
        this(0, 0, null);
    }
    
    public Student(int weight, double cost, String wood){
        this.setWeight(weight);
        this.setCost(cost);
        this.setWood(wood);
        this.setSerialNumber(numberCreated);
        numberCreated++;
    }

    @Override
  public int hashCode() {
//        int hash = 7;
//        hash = 67 * hash + this.weight;
//        hash = 67 * hash + this.serialNumber;
//        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
//        hash = 67 * hash + Objects.hashCode(this.wood);
        return this.serialNumber;
    }
    
    @Override
    public String toString() {
        return "Chair{" + "weight=" + weight + ", cost=" + cost + ", wood=" + wood + ", serialNumber= " + serialNumber + '}';
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    private void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
    

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }
    

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
    
}