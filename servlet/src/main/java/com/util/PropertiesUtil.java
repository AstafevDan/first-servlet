package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static{
        loadProperties();
    }

    private PropertiesUtil(){
        
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\user\\JavaWorkWithDB\\NetWork\\first-servlet\\servlet\\application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
