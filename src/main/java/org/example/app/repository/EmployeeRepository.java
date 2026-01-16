package org.example.app.repository;

import org.example.app.config.DatabaseConnector;
import org.example.app.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public void create(Employee emp) {
        String sql = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emp.getName());
            pstmt.setInt(2, emp.getAge());
            pstmt.setString(3, emp.getPosition());
            pstmt.setDouble(4, emp.getSalary());

            pstmt.executeUpdate();
            System.out.println("Успішно додано: " + emp.getName());

        } catch (SQLException e) {
            System.out.println("Помилка створення: " + e.getMessage());
        }
    }

    // Прочитати всіх (SELECT)
    public List<Employee> fetchAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("position"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
        return list;
    }
}
