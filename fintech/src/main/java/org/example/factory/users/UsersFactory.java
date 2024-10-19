package org.example.factory.users;

import org.example.dao.users.UsersDao;
import org.example.dao.users.impl.UsersDaoImpl;
import org.example.model.User;
import org.example.model.builder.UserBuilder;

import java.sql.SQLException;
import java.time.LocalDate;

public class UsersFactory {

    public static UsersDao getUsersDao() throws SQLException {
        return new UsersDaoImpl();
    }

    public static User createUser() {
        return new UserBuilder()
                .setUsername("Matheus")
                .setLastName("Santos")
                .setEmail("matheusSantos@gmail.com")
                .setPassword("9876543032")
                .setAddress("Rua Queiros Compas")
                .setTelephone("1198785610")
                .setGender("Masculino")
                .setPosition("Pedreiro")
                .setDate(LocalDate.of(2017, 2, 12))
                .build();
    }
}
