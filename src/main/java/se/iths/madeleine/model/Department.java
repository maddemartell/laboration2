package se.iths.madeleine.model;

public class Department {

    private int departmentId;
    private String name;
    private String officeLocation;

    public Department(int departmentId, String name, String officeLocation) {
        this.departmentId = departmentId;
        this.name = name;
        this.officeLocation = officeLocation;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }
}
