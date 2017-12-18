/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Resource;

import com.mycompany.bank_api.Models.Account;
import com.mycompany.bank_api.Models.NewAccount;
import com.mycompany.bank_api.Models.Transaction;
import com.mycompany.bank_api.Service.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author x14532757
 */
@Path("/accounts")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    AccountService accountService = new AccountService();
    NewAccountService newservice = new NewAccountService();
    
    
    //get all customer accounts
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAllAccounts(){
        return accountService.getAllCustomers();
    }
    
    //get account by id
    @GET
    @Path("/{accountNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccountById(@PathParam("accountNumber") int id){
        return accountService.getCustomer(id);
    }
    
    //delete an account
    @DELETE
    @Path("/deleteAccount/{accountNumber}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteAccount(@PathParam("accountNumber") int id){
        Account deletedacc = accountService.deleteCustomer(id);
        String resp = "Customer Account: " + "ID:" + id 
                + ", Customer Name:" + deletedacc.getCustomerName()
                + ", Customer Email:" + deletedacc.getCustomerEmail()
                + ", Customer Address:" + deletedacc.getCustomerAddress() + 
                " (delete status: " + "success)";
        return Response.status(Response.Status.CREATED).entity(resp).build();	
    }
    
    
    //create a new primary customer account
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Account createCustomerAccount(@FormParam("accountNumber") int accountNumber,
                                 @FormParam("customerName") String customerName,
                                 @FormParam("customerAddress") String customerAddress,
                                 @FormParam("customerEmail") String customerEmail,
                                 @FormParam("accountCurrentBalance") double accountCurrentBalance
                                 ){
            return accountService.createCustomer(accountNumber, customerName, customerAddress, customerEmail, accountCurrentBalance);
        }
    
    
    //search your primary account
    @GET
    @Path("/search/{accountNumber}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccountSearch(@QueryParam("accountNumber") int accountNumber) {
        return accountService.searchAccounts(accountNumber);   
    }   
    
    //search other accounts customer has added
    @GET
    @Path("/searchAcc/{accountNumber}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<NewAccount> getCustomerAllAccountsSearch(@QueryParam("accountNumber") int accountNumber) {
        return newservice.searchNewAccounts(accountNumber);   
    } 
    
    
   
}
