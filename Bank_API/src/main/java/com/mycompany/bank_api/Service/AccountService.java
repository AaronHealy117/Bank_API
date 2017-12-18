/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Service;

import com.mycompany.bank_api.Models.Account;
import com.mycompany.bank_api.Models.Transaction;
import com.mycompany.bank_api.Resource.TransactionResource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x14532757
 * 
 * 
 * Resources used
 * http://www.logicbig.com/tutorials/java-ee-tutorial/jax-rs/form-param-post/
 */
public class AccountService {
    public static List<Account> list = new ArrayList<>();
    public static boolean init = true;
    
    TransactionResource serv = new TransactionResource();
    
    //put accounts in list
    public AccountService () {
        if (init) {
            Account c1 = new Account(1,"Aaron", "address 1", "email 1", 5600);
            Account c2 = new Account(2,"Aaron", "address 2", "email 2", 2000);
            Account c3 = new Account(3,"Aaron", "address 3", "email 3", 32000);
            
            list.add(c1);
            list.add(c2);
            list.add(c3);
            init = false;
        }
    }
    
    //get all customer accounts
    public List<Account> getAllCustomers() {
        return list;
    }

    //get customer account by account number
    public Account getCustomer(int id){
        return list.get(id-1);
    }
    
    //delete a customer account
    public Account deleteCustomer(int id){
        return list.remove(id-1);
    }
    
    //add customer account to list
    public Account createCustomers(Account acc){
    list.add(acc);
    return acc;
    }
    
    //add new account
    public Account createCustomer(int accountNumber, String customerName, String customerAddress, String customerEmail, double accountCurrentBalance) {
        
        Account acc = new Account();
        
        List<Account> match = new ArrayList<>();
        
        for (Account u: getAllCustomers()) {
            if ( u.getAccountNumber() == accountNumber){
               return null;
            }
        }
        
        acc.setAccountNumber(accountNumber);
        acc.setCustomerName(customerName);
        acc.setCustomerAddress(customerAddress);
        acc.setCustomerEmail(customerEmail);
        acc.setAccountCurrentBalance(accountCurrentBalance);
        
        return createCustomers(acc);
    }
    
    //get account information by account number
    public List<Account> searchAccounts(int accountNumber) {
        List<Account> matcheslist = new ArrayList<>();
        
        for (Account u: getAllCustomers()) {
            if ( u.getAccountNumber() == accountNumber){
               matcheslist.add(u);
            }
        }
        return matcheslist;
    }
    
    
    //update balance of account balance
    //information got from transactionservice to update balance when the user creates a transaction
    public Account updateBalance(int accountNumber, String customerName, String customerAddress, String customerEmail, double accountCurrentBalance){
        
        Account acc = new Account();
        
        acc.setAccountNumber(accountNumber);
        acc.setCustomerName(customerName);
        acc.setCustomerAddress(customerAddress);
        acc.setCustomerEmail(customerEmail);
        acc.setAccountCurrentBalance(accountCurrentBalance);
        
        return update(acc, accountNumber);
    }
    
    //add update to list
    public Account update(Account acc, int AccountNumber){
        list.set(AccountNumber-1, acc);
        return acc;
    }
    
}
