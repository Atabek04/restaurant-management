package com.otabek.restaurant_management.dao;

import com.otabek.restaurant_management.models.Order;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Component
public class OrderDAO {
    private List<Order> orders;
    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "91926499";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Order> getOrders(){

        return null;
    }
}
