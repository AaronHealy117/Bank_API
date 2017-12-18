/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Models;

/**
 *
 * @author x14532757
 */
public class NewAccount {
    
    Branch branch = new Branch();
    
    private int accountNumber;
    private int newAccountNumber;
    private String accountType;
    private String accountSortCode = branch.getBranchCode();
    private double accountBalance;

    public NewAccount() {
    }

    public NewAccount(int accountNumber, int newAccountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.newAccountNumber = newAccountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    

    public int getNewAccountNumber() {
        return newAccountNumber;
    }

    public void setNewAccountNumber(int newAccountNumber) {
        this.newAccountNumber = newAccountNumber;
    }

    

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountSortCode() {
        return accountSortCode;
    }

    public void setAccountSortCode(String accountSortCode) {
        this.accountSortCode = accountSortCode;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

   
    
    
    
}
