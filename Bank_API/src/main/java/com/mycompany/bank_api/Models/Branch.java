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
public class Branch {
    
     private String branchCode = "11_22_33";

    public Branch() {
    }
    
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    
}
