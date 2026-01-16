package org.example.app;

import org.example.app.entity.Employee;
import org.example.app.repository.EmployeeRepository;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();

        System.out.println("--- ПОЧАТОК РОБОТИ ---");


        repo.create(new Employee("Ivan", 25, "Junior Java", 900.0));
        repo.create(new Employee("Oksana", 32, "PM", 2500.0));


        System.out.println("\n--- СПИСОК СПІВРОБІТНИКІВ ---");
        for (Employee worker : repo.fetchAll()) {
            System.out.println(worker);
        }
    }
}
