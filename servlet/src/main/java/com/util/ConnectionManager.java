package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConnectionManager {
    private final static String URL_KEY = "db.url";
    private final static String USERNAME_KEY = "db.username";
    private final static String PASSWORD_KEY = "db.password";

    static{
        loadDriver();
    }

    @SneakyThrows
    public static Connection open(){
            return DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                                                PropertiesUtil.get(USERNAME_KEY),
                                                PropertiesUtil.get(PASSWORD_KEY));
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
