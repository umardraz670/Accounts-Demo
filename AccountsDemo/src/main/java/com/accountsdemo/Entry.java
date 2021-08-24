/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountsdemo;

import java.sql.Date;

/**
 *
 * @author Orax Solution Provider +923219598676
 */
public class Entry {

    private int Id;
    private String description;
    private int accountType;
    private Date entryDate;
    private float amount;
    private int generalId;
    private String user;

    public Entry() {
    }

    public Entry(int Id, String description, int accountType, Date createDate, float amount, int generalId, String user) {
        this.Id = Id;
        this.description = description;
        this.accountType = accountType;
        this.entryDate = createDate;
        this.amount = amount;
        this.generalId = generalId;
        this.user = user;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public Date getCreateDate() {
        return entryDate;
    }

    public void setCreateDate(Date createDate) {
        this.entryDate = createDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getGeneralId() {
        return generalId;
    }

    public void setGeneralId(int generalId) {
        this.generalId = generalId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    

}
