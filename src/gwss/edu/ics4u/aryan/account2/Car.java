/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.aryan.account2;

import java.util.Objects;

/**
 *
 * @author Aryan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Car {

    public static final int TEXT_FIELD = 20;

    private String liscensePlate;
    private String carName;
    private int serialNumber;

    public Car(String liscensePlate, String carName, int serialNumber) {
        this.setLiscensePlate(liscensePlate);
        this.setCarName(carName);
        this.setSerialNumber(serialNumber);
    }

    public String toString() {
        return "Name: " + this.getCarName() + "\n"
                + "Liscense Plate: " + this.getLiscensePlate() + "\n"
                + "Serial Number: " + this.getSerialNumber() + "\n";
    }

    public String getLiscensePlate() {
        return this.liscensePlate;
    }

    public void setLiscensePlate(String liscensePlate) {
        if (liscensePlate.length() == 8) {
            this.liscensePlate = liscensePlate;
        } else {
            this.liscensePlate = "TBD";
        }
    }

    public String getCarName() {
        return this.carName;
    }

    public void setCarName(String carName) {
        if (carName.length() <= TEXT_FIELD) {
            this.carName = carName;
        } else {
            this.carName = "Invalid";
        }
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        if (serialNumber >= 0 && serialNumber < 10000) {
            this.serialNumber = serialNumber;
        } else {
            this.serialNumber = -1;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.liscensePlate);
        hash = 37 * hash + Objects.hashCode(this.carName);
        hash = 37 * hash + this.serialNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.liscensePlate, other.liscensePlate)) {
            return false;
        }
        if (!Objects.equals(this.carName, other.carName)) {
            return false;
        }
        if (this.serialNumber != other.serialNumber) {
            return false;
        }
        return true;
    }

}
