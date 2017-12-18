/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Models;


import java.util.Random;

/**
 *
 * @author x14532757
 */
public class Account {
    
    Branch branch = new Branch();
   
    //create pincode
    Random ran2 = new Random();
    int a = 1000 + ran2.nextInt(5000);
    
    //customer account info
    private int accountNumber;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private int customerPinCode  = a;
    private String accountSortCode = branch.getBranchCode();
    private double accountCurrentBalance;

    public Account() {
    }

    public Account(int accountNumber, String customerName, String customerAddress, String customerEmail, double accountCurrentBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.accountCurrentBalance = accountCurrentBalance;
        
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountCurrentBalance() {
        return accountCurrentBalance;
    }

    public void setAccountCurrentBalance(double accountCurrentBalance) {
        this.accountCurrentBalance = accountCurrentBalance;
    }

    public int getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(int customerPinCode) {
        this.customerPinCode = customerPinCode;
    }


}
