package com.otabek.restaurant_management.models;

public class OrderItem {
    private int id;
    MenuItem menuItem;
    int quantity;
    int price;

    public OrderItem(int id, MenuItem menuItem, int quantity, int price) {
        this.id = id;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
