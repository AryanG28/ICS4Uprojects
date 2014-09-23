/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwss.edu.ics4u.account;

/**
 *
 * @author 1GHAHREMANZA
 */
public class Account {
    private int accountNumber;
    private int branchNumber;
    private String accountType;
    private int pin;
    private double accountBalance;
    private boolean active;

    public Account() {
    }

    public Account(int accountNumber, int branchNumber, String accountType, int pin, double accountBalance, boolean active) {
        this.accountNumber = accountNumber;
        this.branchNumber = branchNumber;
        this.accountType = accountType;
        this.pin = pin;
        this.accountBalance = accountBalance;
        this.active = active;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) { 
        this.active = active;
    }
    
    public void transfer(double transferAmount, double accountBalance) {
            
    }
    
    public double withdrawal(double withdrawal, double accountBalance) {
        return this.accountBalance;   
    }
    
    public double deposit(double deposit, double accountBalance) {
        return this.accountBalance;
    }
    
    public void checkPin(int pinNumber) {
    if (this.pin == pinNumber) {
        
    }      
    }
    
    public void active() {
    }
    
    
    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", branchNumber=" + branchNumber + ", accountType=" + accountType + ", pin=" + pin + ", accountBalance=" + accountBalance + ", active=" + active + '}';
    }


}
