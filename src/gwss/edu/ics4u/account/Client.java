/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.account;

import java.util.Objects;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Client {
    private String firstName;
    private String lastName;
    private int SIN;

    public Client(String firstName, String lastName, int SIN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SIN = SIN;
    }

    public Client(int SIN) {
        this.SIN = SIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    @Override
    public String toString() {
        return "AccountClient{" + "firstName=" + firstName + ", lastName=" + lastName + ", SIN=" + SIN + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (this.SIN != other.SIN) {
            return false;
        }
        return true;
    }
    
}
