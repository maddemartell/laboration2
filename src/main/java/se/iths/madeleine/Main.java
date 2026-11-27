package se.iths.madeleine;

import se.iths.madeleine.model.AccessCard;
import se.iths.madeleine.model.Competence;
import se.iths.madeleine.model.Department;
import se.iths.madeleine.model.Employee;

import java.time.LocalDate;

public class Main {

    public static void printEmployee(Employee employee) {
        IO.println("Employee: " + employee.getFirstName() + " " + employee.getLastName());
        IO.println("Department: " + employee.getDepartment().getName());
        if (employee.getAccessCard() == null) {
            IO.println("Employee doesn´t has an access card");
        } else {
            IO.println("AccessCard: " + employee.getAccessCard().getCardNumber());
        }
        if (employee.getCompetences().isEmpty()) {
            IO.println("Employee has no competences");
        } else {
            IO.println("Competences:");
            for (Competence competence : employee.getCompetences())
                IO.println(competence.getName());
        }
    }

    static void main() {

        Department department1 = new Department(1, "Department1", "Address1");
        Department department2 = new Department(2, "Department2", "Address2");
        Department department3 = new Department(3, "Department3", "Address3");
        Department department4 = new Department(4, "Department4", "Address4");

        Employee employee1 = new Employee(1, "Anna", "Andersson", "email1", LocalDate.parse("2020-02-09"), department1);
        Employee employee2 = new Employee(2, "Emma", "Karlsson", "email2", LocalDate.parse("2023-02-03"), department1);
        Employee employee3 = new Employee(3, "Erik", "Johansson", "email3", LocalDate.parse("2022-02-06"), department1);
        Employee employee4 = new Employee(4, "Hanna", "Hansson", "email4", LocalDate.parse("2021-03-05"), department2);
        Employee employee5 = new Employee(5, "Jan", "Jansson", "email5", LocalDate.parse("2020-02-09"), department2);
        Employee employee6 = new Employee(6, "Ellen", "Jansson", "email6", LocalDate.parse("2019-02-01"), department3);
        Employee employee7 = new Employee(7, "Sara", "Svensson", "email7", LocalDate.parse("2017-02-01"), department3);

        AccessCard accessCard1 = new AccessCard(1, "CardNumber1", LocalDate.parse("2025-05-05"), LocalDate.parse("2028-05-05"));
        AccessCard accessCard2 = new AccessCard(2, "CardNumber2", LocalDate.parse("2024-01-01"), LocalDate.parse("2027-02-02"));
        AccessCard accessCard3 = new AccessCard(3, "CardNumber3", LocalDate.parse("2022-01-01"), LocalDate.parse("2026-02-05"));
        AccessCard accessCard4 = new AccessCard(4, "CardNumber4", LocalDate.parse("2023-01-01"), LocalDate.parse("2029-02-05"));

        employee1.setAccessCard(accessCard1);
        employee3.setAccessCard(accessCard2);
        employee4.setAccessCard(accessCard3);
        employee7.setAccessCard(accessCard4);

        Competence competence1 = new Competence(1, "SQL", "Ability to work with SQL");
        Competence competence2 = new Competence(2, "Java", "Ability to work with Java");
        Competence competence3 = new Competence(3, "Project management", "Ability to manage projects");

        employee1.addCompetence(competence1);
        employee1.addCompetence(competence2);
        employee2.addCompetence(competence1);
        employee3.addCompetence(competence1);
        employee4.addCompetence(competence2);

        printEmployee(employee1);
        printEmployee(employee2);
        printEmployee(employee3);
        printEmployee(employee4);
        printEmployee(employee5);
        printEmployee(employee6);
        printEmployee(employee7);
    }
}

