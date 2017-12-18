/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Service;

import com.mycompany.bank_api.Models.NewAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x14532757
 * 
 * Resources used
 * http://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/form-param-post/
 */
public class NewAccountService {
    public static List<NewAccount> list = new ArrayList<>();
    public static boolean init = true;
    
    //add new accounts to list
    public NewAccountService () {
        if (init) {
            NewAccount c1 = new NewAccount(1, 1, "Savings", 5600);
            NewAccount c2 = new NewAccount(2, 2, "College something i dunno", 2000);
            NewAccount c3 = new NewAccount(2, 3, "Savings", 32000);
            NewAccount c4 = new NewAccount(3, 4, "Savings", 313);
            
            list.add(c1);
            list.add(c2);
            list.add(c3);
            list.add(c4);
            init = false;
        }
    }
    
    //get all new accounts
    public List<NewAccount> getAllNewAccounts() {
        return list;
    }
    
    //get all new accounts by account number
    public NewAccount getNewAccountById(int id){
        return list.get(id-1);
    }
    
    public List<NewAccount> getNewAccountList(int id){
        return list;
    }
    
    //search accounts by primary account number
    public List<NewAccount> searchNewAccounts(int accountNumber) {
        List<NewAccount> matcheslist = new ArrayList<>();
        
        for (NewAccount u: getAllNewAccounts()) {
            if ( u.getAccountNumber() == accountNumber){
               matcheslist.add(u);
            }
        }
        return matcheslist;
    }
    
    
    
    
    
    
    public NewAccount deleteNewAccounts(int id){
        return list.remove(id-1);
    }
    
    
    public NewAccount createNewAccounts(NewAccount acc){
    list.add(acc);
    return acc;
    }
    
    public NewAccount createNewAccount(int accountNumber, String accountType, double accountBalance) {
        
        NewAccount acc = new NewAccount();
        
        acc.setAccountNumber(accountNumber);
        acc.setAccountType(accountType);
        acc.setAccountBalance(accountBalance);
        
        return createNewAccounts(acc);
    }

    
}
