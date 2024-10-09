package org.example;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            System.out.println("Conexão Realizada");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
