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
public class AccountClient {
    
    public static void main(String[] args) {
        Account account= new Account();
        account.setAccountNumber(123);
        account.setBranchNumber(123);
        account.setAccountType(null);
        account.setAccountBalance(300);
        
        Client muir = new Client("Will", "Muir", 123456789);
        
        account.setAccountOwner(muir);
        account.getAccountOwner().getLastName();
        
        
        
       Account account2 = new Account();
        account2.setAccountNumber(123);
        account2.setBranchNumber(123);
        account2.setAccountType(null);
        account2.setAccountBalance(300);
        
        
        
        account.setAccountOwner(muir);
        account2.setAccountOwner(muir);
        muir.addAccount().add (account);
        muir.setAccounts().add (account2);
        
        
    }
    
}
