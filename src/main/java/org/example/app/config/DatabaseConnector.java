package org.example.app.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    public static Connection getConnection() {
        Properties props = new Properties();

        // Завантажуємо файл app.properties
        try (InputStream input = DatabaseConnector.class.getClassLoader()
                .getResourceAsStream("app.properties")) {

            if (input == null) {
                System.out.println("ПОМИЛКА: Не знайдено app.properties!");
                return null;
            }
            props.load(input);


            return DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password")
            );

        } catch (IOException | SQLException e) {
            System.out.println("ПОМИЛКА ПІДКЛЮЧЕННЯ: " + e.getMessage());
            return null;
        }
    }
}
