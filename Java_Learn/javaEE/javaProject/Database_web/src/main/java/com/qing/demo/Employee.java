package com.qing.demo;

/**
 * @Classname employee
 * @Description TODO
 * @Date 2019/7/29 19:13
 * @Created by AppleTree
 */
public class Employee {

    private int employeeID;
    private String employeeName;
    private int location;

    public Employee(int employeeID, String employeeName, int location) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.location = location;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", location=" + location +
                '}';
    }
}
