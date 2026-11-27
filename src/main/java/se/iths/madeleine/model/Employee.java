package se.iths.madeleine.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hiringDate;
    private Department department;
    private AccessCard accessCard;

    private List<Competence> competences = new ArrayList<>();

    public Employee(int employeeId, String firstName, String lastName, String email, LocalDate hiringDate, Department department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hiringDate = hiringDate;
        this.department = department;
    }

    public void addCompetence(Competence competence) {
        competences.add(competence);
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public Department getDepartment() {
        return department;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }
}
