/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Resource;

import com.mycompany.bank_api.Models.Transaction;
import com.mycompany.bank_api.Service.AccountService;
import com.mycompany.bank_api.Service.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author x14532757
 * 
 * Resources Used
 * http://coenraets.org/blog/2011/12/restful-services-with-jquery-and-java-using-jax-rs-and-jersey/
 */
@Path("/transactions")
public class TransactionResource {
    
    TransactionService transactionservice = new TransactionService();
    
    //get all transactions
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactions() {
        return transactionservice.getAllTransactions();
    }  
    
    //get transaction by account number
    @GET
    @Path("/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction getAccountTransactionstById(@QueryParam("accountId") int id){
        return transactionservice.getTransaction(id);
    }
    
    //get data from form and create new transaction
    @POST
    @Path("/makeLodgement")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction makeLodgementTransaction(@FormParam("accountNumber") int accountNumber,
                                @FormParam("transactionAccountType") String transactionAccountType,
                                @FormParam("transactionDescription") String transactionDescription,
                                @FormParam("transactionLodgment") double transactionLodgment
                                 ){
        
            return transactionservice.makeLodgement(accountNumber, transactionAccountType, transactionDescription, transactionLodgment);
        }
    
    //get data from form and create new transaction
    @POST
    @Path("/makeWithdrawal")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction makeWithdrawalTransaction(@FormParam("accountNumber") int accountNumber,
                                @FormParam("transactionAccountType") String transactionAccountType,
                                @FormParam("transactionDescription") String transactionDescription,
                                @FormParam("transactionWithdrawal") double transactionWithdrawal
                                 ){
        
            return transactionservice.makeWithdrawal(accountNumber, transactionAccountType, transactionDescription, transactionWithdrawal);
        }
    
    //get data from form and create new transaction
    @POST
    @Path("/makeTransfer")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction makeTransferTransaction(@FormParam("accountNumber") int accountNumber,
                                @FormParam("transactionAccountType") String transactionAccountType,
                                @FormParam("transactionDescription") String transactionDescription,
                                @FormParam("transactionTransfer") double transactionTransfer
                                 ){
                                 
            return transactionservice.makeTransfer(accountNumber, transactionAccountType, transactionDescription, transactionTransfer);
        }
    
    
    //get all transactions with your account number
    @GET
    @Path("/searchTran/{accountNumber}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getUsersTransactionsSearch(@QueryParam("accountNumber") int accountNumber) {
        return transactionservice.searchTransactions(accountNumber);   
    } 
    
    
}
