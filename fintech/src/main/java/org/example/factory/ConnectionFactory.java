package org.example.factory;

import org.example.exception.AppFintechException;
import org.example.exception.ErrorTypeEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "RM557586";
    private static final String SENHA = "120398";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
            return connection;
        } catch (Exception ex) {
            throw new AppFintechException(ex.getMessage(), ex, ErrorTypeEnum.ERROR_CONNECTING_TO_DATABASE);
        }
    }
}
