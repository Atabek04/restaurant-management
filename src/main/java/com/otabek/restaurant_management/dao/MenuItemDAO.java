package com.otabek.restaurant_management.dao;

import com.otabek.restaurant_management.models.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemDAO {
    private List<MenuItem> menuItems;
    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "91926499";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MenuItem> getMenuItems() {
        menuItems = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM \"menuItems\"";
            ResultSet rs = statement.executeQuery(SQL);

            while (rs.next()){
                MenuItem menuItem = new MenuItem();
                menuItem.setId(rs.getInt("menuItem_id"));
                menuItem.setName(rs.getString("menuItem_name"));
                menuItem.setPrice(rs.getInt("menuItem_price"));
                menuItems.add(menuItem);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return menuItems;
    }


    public MenuItem getItemByID(int id) {
        for(MenuItem item : menuItems){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
}
