package com.otabek.restaurant_management.models;

public class Table {
    private int id;
    private int number;
    private int status = 0;

    public Table(int id, int number, int status) {
        this.id = id;
        this.number = number;
        this.status = status;
    }

    public Table() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void reserve(){
        this.status = 1;
    }

    public void unReserve(){
        this.status = 0;
    }
}
