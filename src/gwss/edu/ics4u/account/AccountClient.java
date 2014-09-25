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
        Account account = new Account();
        account.setAccountNumber( 123 );
        account.setBranchNumber( 1234 );
        account.setAccountType( Account.ACCOUNT_TYPE_SAVINGS );
        account.setAccountBalance(1000.00 );
        
        Account account2 = new Account();
        account2.setAccountNumber( 124 );
        account2.setBranchNumber( 1234 );
        account2.setAccountType( Account.ACCOUNT_TYPE_CHEQUING );
        account2.setAccountBalance( 1001.00 );

         Account account3 = new Account();
        account.setAccountNumber( 125 );
        account.setBranchNumber( 1235 );
        account.setAccountType( Account.ACCOUNT_TYPE_SAVINGS );
        account.setAccountBalance(1000.00 );
        
        Account account4 = new Account();
        account2.setAccountNumber( 126 );
        account2.setBranchNumber( 1236 );
        account2.setAccountType( Account.ACCOUNT_TYPE_CHEQUING );
        account2.setAccountBalance( 2.00 );
        
        Client muir = new Client( "Will", "Muir", 123456789 );

        account.setAccountOwner( muir );
        account2.setAccountOwner( muir );
        account3.setAccountOwner(muir);
        account4.setAccountOwner(muir);
        
        muir.addAccount( account );
        muir.addAccount( account2 );
        muir.addAccount( account3 );
        muir.addAccount( account4 );
       
        System.out.println( "Account: " + muir.getAccount( 124, 1234 ) );
             

        
    }
    
}
