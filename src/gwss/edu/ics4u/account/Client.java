/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.account;

import java.util.ArrayList;
/**
 *
 * @author 1GHAHREMANZA
 */
public class Client {
    
    private String firstName;
    private String lastName;
    private int SIN;
    private ArrayList<Account> accounts;
    

    public Client() {
        this.accounts = new ArrayList<Account>();
    }

    public Client( String firstName, String lastName, int SIN ) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.SIN = SIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN( int SIN ) {
        this.SIN = SIN;
    }

    public Account getAccount( int accountNumber, int branchNumber ) {
        Account account = null;
        boolean found = false;
        for( int i = 0; i < this.accounts.size(); i++ ) {
            account = this.accounts.get( i );
            if( account.getAccountNumber() == accountNumber && account.getBranchNumber() == branchNumber ) {
                found = true;
                i = this.accounts.size();
            }
        }
        if( found ) return account;
        else return null;
    }

    public void addAccount( Account account ) {
        this.accounts.add(  account );
    }

    
    
    @Override
    public String toString() {
        return "Client{" + "firstName=" + firstName + ", lastName=" + lastName + ", SIN=" + SIN + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Client other = (Client) obj;
        if ( this.SIN != other.SIN ) {
            return false;
        }
        return true;
    }
    
    
    
}
