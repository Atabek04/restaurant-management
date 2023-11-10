package com.otabek.restaurant_management.models;

import java.util.List;

public class Order {
    private int id;
    private Table table;
    private int status;
    private List<OrderItem> orderItems;

    public Order(int id, Table table, int status, List<OrderItem> orderItems) {
        this.id = id;
        this.table = table;
        this.status = status;
        this.orderItems = orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

}
