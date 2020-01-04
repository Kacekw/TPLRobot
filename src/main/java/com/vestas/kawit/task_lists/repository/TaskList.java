package com.vestas.kawit.task_lists.repository;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.util.List;

@Entity
public class TaskList {

    private int plant;
    private int taskList;
    @Id
    private int plantAndTaskList;

    @NotNull
    @NotEmpty(message = "Long text cannot be empty.")
    private String longText;
    @NotEmpty(message = "Operations cannot be empty.")
    @ElementCollection(targetClass = OrderOperation.class) @OneToMany(cascade = CascadeType.ALL)
    private List<OrderOperation> operations;
    @ElementCollection(targetClass = OrderComponent.class) @OneToMany(cascade = CascadeType.ALL)
    private List<OrderComponent> components;

    @FutureOrPresent
    private Date date;

    public TaskList() {
    }

    public TaskList(int plant, int taskList, @NotNull @NotEmpty(message = "Long text cannot be empty.") String longText, @NotEmpty(message = "Operations cannot be empty.") List<OrderOperation> operations, List<OrderComponent> components) {
        this.plant = plant;
        this.taskList = taskList;
        this.longText = longText;
        this.operations = operations;
        this.components = components;
        this.date = new Date(System.currentTimeMillis());
        this.plantAndTaskList = Integer.parseInt(String.format("%d%d", plant, taskList));
    }

    public int getPlant() {
        return plant;
    }

    public void setPlant(int plant) {
        this.plant = plant;
    }

    public int getTaskList() {
        return taskList;
    }

    public void setTaskList(int taskList) {
        this.taskList = taskList;
    }

    public int getPlantAndTaskList() {
        return plantAndTaskList;
    }

    public void setPlantAndTaskList(int plantAndTaskList) {
        this.plantAndTaskList = plantAndTaskList;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public List<OrderOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<OrderOperation> operations) {
        this.operations = operations;
    }

    public List<OrderComponent> getComponents() {
        return components;
    }

    public void setComponents(List<OrderComponent> components) {
        this.components = components;
    }

    public Date getDate() {
        return date;
    }

}
