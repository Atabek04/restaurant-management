package com.otabek.restaurant_management.dao;

import com.otabek.restaurant_management.models.Table;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TableDAO {
    List<Table> tables;
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

    public List<Table> getTables(){
        tables = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM tables";
            ResultSet rs = statement.executeQuery(SQL);

            while (rs.next()){
                Table table = new Table();
                table.setId(rs.getInt("id"));
                table.setNumber(rs.getInt("number"));
                table.setNumber(rs.getInt("number"));
                table.setStatus(rs.getInt("status"));

                tables.add(table);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tables;
    }

    public Table getTableById(int id) {
        for(Table table : tables){
            if(table.getId() == id){
                return table;
            }
        }
        return null;
    }
}