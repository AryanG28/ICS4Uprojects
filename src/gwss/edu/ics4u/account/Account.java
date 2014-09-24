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
public class Account {
    
    public static final int ACCOUNT_TYPE_UNKNOWN = 0;
    public static final int ACCOUNT_TYPE_SAVINGS = 1;
    public static final int ACCOUNT_TYPE_CHEQUING = 2;
    
    public static final String[] ACCOUNT_TYPE_NAMES = {
        "Unknown", "Savings", "Chequing"
    };
    
    private Client accountOwner;
    private int accountNumber;
    private int branchNumber;
    private String accountType;
    private int pin;
    private double accountBalance;
    private boolean active;
    private ArrayList<Account> accounts;
    
    public Account() {
    }

    public Account(Client accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Client getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Client accountOwner) {
        this.accountOwner = accountOwner;
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
    
    public double transfer(double transferAmount, double accountBalance) {
        
        return this.accountBalance;
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
    
    private Account getAccount(int accountNumber, int BranchNumber) { 
            Account account = null;
            boolean found = false;
            for (int i= 0; i<this.accounts.size(); i++) {
                account = this.accounts.get(i);
                if ( account.getAccountNumber()== accountNumber && account.getBranchNumber()== branchNumber) {
                    found = true;
                    i = this.accounts.size();
                }
            }
            
    }
    
    public void addAccount (Account account) {
       
    }
    public void active() {
    }
    
    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", branchNumber=" + branchNumber + ", accountType=" + accountType + ", pin=" + pin + ", accountBalance=" + accountBalance + ", active=" + active + '}';
    }


}
