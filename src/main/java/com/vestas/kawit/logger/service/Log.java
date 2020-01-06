package com.vestas.kawit.logger.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String user;
    private String backendStep;
    private Date date;
    @NotNull
    private float orderNo;
    private String orderType;

    private String oldLongText;
    private String newLongText;

    @NotNull
    private LogTypes type;
    @NotNull
    private LogSubTypes subType;

    public Log(@NotEmpty String user, String backendStep, Date date, @NotNull float orderNo, String orderType, String oldLongText, String newLongText, @NotNull LogTypes type, @NotNull LogSubTypes subType) {
        this.user = user;
        this.backendStep = backendStep;
        this.date = date;
        this.orderNo = orderNo;
        this.orderType = orderType;
        this.oldLongText = oldLongText;
        this.newLongText = newLongText;
        this.type = type;
        this.subType = subType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBackendStep() {
        return backendStep;
    }

    public void setBackendStep(String backendStep) {
        this.backendStep = backendStep;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(float orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOldLongText() {
        return oldLongText;
    }

    public void setOldLongText(String oldLongText) {
        this.oldLongText = oldLongText;
    }

    public String getNewLongText() {
        return newLongText;
    }

    public void setNewLongText(String newLongText) {
        this.newLongText = newLongText;
    }

    public LogTypes getType() {
        return type;
    }

    public void setType(LogTypes type) {
        this.type = type;
    }

    public LogSubTypes getSubType() {
        return subType;
    }

    public void setSubType(LogSubTypes subType) {
        this.subType = subType;
    }
}