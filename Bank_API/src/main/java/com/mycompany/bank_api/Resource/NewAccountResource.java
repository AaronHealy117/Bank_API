/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank_api.Resource;


import com.mycompany.bank_api.Models.NewAccount;
import com.mycompany.bank_api.Service.NewAccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author x14532757
 */
@Path("/newaccounts")
public class NewAccountResource {
    
    NewAccountService newaccountservice = new NewAccountService();
    
    //get all customers accounts
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NewAccount> getAllNewAccounts(){
        return newaccountservice.getAllNewAccounts();
    }
    
    
    //delete a customers accounts
    @DELETE
    @Path("/deleteNewAccount/{newAccountNumber}")
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteNewAccount(@PathParam("newAccountNumber") int id){
        NewAccount deletedacc = newaccountservice.deleteNewAccounts(id);
        String resp = "Customer Account: " + "ID:" + id ;
        return Response.status(Response.Status.CREATED).entity(resp).build();	
    }
     
    //create a new customer account
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public NewAccount createNewCustomerAccount(@FormParam("accountNumber") int accountNumber,
                                 @FormParam("accountType") String accountType,
                                 @FormParam("accountBalance") double accountBalance
                                 ){
            return newaccountservice.createNewAccount(accountNumber, accountType, accountBalance);
        }
    
    
}
