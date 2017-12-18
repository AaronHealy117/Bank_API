/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Service;

import com.mycompany.bank_api.Models.Account;
import com.mycompany.bank_api.Models.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x14532757
 */
public class TransactionService {
    public static List<Transaction> list = new ArrayList<>();
    
    
    //put transaction in list
    public TransactionService () {
        if(list.isEmpty()){
            //Transaction t1 = new Transaction(1, "Debit", "Lodgment", 300, 0, 0);
            //Transaction t2 = new Transaction(1, "Debit", "Lodgment", 11000, 0, 0);
            //Transaction t3 = new Transaction(2, "Credit", "Lodgment", 400, 0, 0);
            //Transaction t4 = new Transaction(3, "Credit", "Lodgment", 400, 0, 0);
            
            //list.add(t1); 
            //list.add(t2);
            //list.add(t3);
            //list.add(t4);
        }
    }
    
    //get all transactions
    public List<Transaction> getAllTransactions() {
        return list;
    }
    
    //get transaction by account number
    public Transaction getTransaction(int id){
        return list.get(id-1);
    }
    
    //add data to list
    public Transaction makeTransaction(Transaction tra){
    list.add(tra);
    return tra;
    }
    
    //add transaction data to list
    public Transaction makeLodgement(int accountNumber, String transactionAccountType, String transactionDescription, double transactionLodgment) {
        
        Transaction tra = new Transaction();
        
        tra.setAccountNumber(accountNumber);
        tra.setTransactionAccountType(transactionAccountType);
        tra.setTransactionDescription(transactionDescription);
        tra.setTransactionLodgment(transactionLodgment);
        
        //get accountservice
        AccountService serv = new AccountService();
        
        //get all customer accounts
        for(Account acc : serv.getAllCustomers()){
            //if account numbers match
            if(acc.getAccountNumber() == accountNumber){
                
                //update account with this information
                String customerName = acc.getCustomerName();
                String customerAddress = acc.getCustomerAddress();
                String customerEmail = acc.getCustomerEmail();
                //update lodgment
                double newbal = acc.getAccountCurrentBalance() + transactionLodgment;
                serv.updateBalance(accountNumber, customerName, customerAddress, customerEmail, newbal);
            
            }
        }
        
        return makeTransaction(tra);
    }
    
    //add transaction data to list
    public Transaction makeWithdrawal(int accountNumber, String transactionAccountType, String transactionDescription, double transactionWithdrawal) {
        
        Transaction tra = new Transaction();
        
        tra.setAccountNumber(accountNumber);
        tra.setTransactionAccountType(transactionAccountType);
        tra.setTransactionDescription(transactionDescription);
        tra.setTransactionWithdrawal(transactionWithdrawal);
        
        AccountService serv = new AccountService();
        
        for(Account acc : serv.getAllCustomers()){
            if(acc.getAccountNumber() == accountNumber){
                
                String customerName = acc.getCustomerName();
                String customerAddress = acc.getCustomerAddress();
                String customerEmail = acc.getCustomerEmail();
                double newbal = acc.getAccountCurrentBalance() - transactionWithdrawal;
                serv.updateBalance(accountNumber, customerName, customerAddress, customerEmail, newbal);
            
            }
        }
        
        
        return makeTransaction(tra);
    }
    
    
    public Transaction makeTransfer(int accountNumber, String transactionAccountType, String transactionDescription, double transactionTransfer) {
        
        Transaction tra = new Transaction();
        
        tra.setAccountNumber(accountNumber);
        tra.setTransactionAccountType(transactionAccountType);
        tra.setTransactionDescription(transactionDescription);
        tra.setTransactionTransfer(transactionTransfer);
        
        return makeTransaction(tra);
    }
    
    //get transactions by account number
    public List<Transaction> searchTransactions(int accountNumber) {
        List<Transaction> matcheslist = new ArrayList<>();
        
        for (Transaction u: getAllTransactions()) {
            if ( u.getAccountNumber() == accountNumber){
               matcheslist.add(u);
            }
        }
        return matcheslist;
    }
    
    
    
}
