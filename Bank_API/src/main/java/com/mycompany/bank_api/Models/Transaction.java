/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Models;

import java.util.Date;

/**
 *
 * @author x14532757
 */
public class Transaction {

    private int AccountNumber;
    private String transactionAccountType;
    private String transactionDescription;
    private Date date = new Date();
    private double transactionLodgment;
    private double transactionWithdrawal;
    private double transactionTransfer;

    public Transaction() {
    }

    public Transaction(int AccountNumber, String transactionAccountType, String transactionDescription, double transactionLodgment, double transactionWithdrawal, double transactionTransfer) {
        this.AccountNumber = AccountNumber;
        this.transactionAccountType = transactionAccountType;
        this.transactionDescription = transactionDescription;
        this.transactionLodgment = transactionLodgment;
        this.transactionWithdrawal = transactionWithdrawal;
        this.transactionTransfer = transactionTransfer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public double getTransactionWithdrawal() {
        return transactionWithdrawal;
    }

    public void setTransactionWithdrawal(double transactionWithdrawal) {
        this.transactionWithdrawal = transactionWithdrawal;
    }

    public double getTransactionTransfer() {
        return transactionTransfer;
    }

    public void setTransactionTransfer(double transactionTransfer) {
        this.transactionTransfer = transactionTransfer;
    }

    

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getTransactionAccountType() {
        return transactionAccountType;
    }

    public void setTransactionAccountType(String transactionAccountType) {
        this.transactionAccountType = transactionAccountType;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public double getTransactionLodgment() {
        return transactionLodgment;
    }

    public void setTransactionLodgment(double transactionLodgment) {
        this.transactionLodgment = transactionLodgment;
    }
    
    
    
     
    
}
