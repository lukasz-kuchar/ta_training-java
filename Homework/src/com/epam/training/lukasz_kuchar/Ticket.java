package com.epam.training.lukasz_kuchar;

public class Ticket {

    int id;
    String name;
    public int estimate;
    boolean isCompleted;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.isCompleted = false;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        if(this.isCompleted){
            return true;
        }else{
            return false;
        }
    }

    public void complete() {
        this.isCompleted = true;
    }

    public int getEstimate() {
        return this.estimate;
    }
}

