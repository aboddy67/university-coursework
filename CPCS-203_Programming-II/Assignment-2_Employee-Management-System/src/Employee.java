/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

import java.util.ArrayList;

// Employee class is an abstract class having all the common attributes and methods for all employees
public abstract class Employee {
    private String name;
    private int id;
    private double salary;
    private String state;
    private final ArrayList<Leave> LeaveRecords; // to store the leave records of the employee

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.state = "Working";
        LeaveRecords = new ArrayList<>();
    }

    // Making it abstract so that each employee implements the bonus accordingly
    public abstract double calculateBonus();

    @Override
    public String toString() {
        return "Name: " + name + " ID: " + id + " Salary: " + salary;
    }

    public void setStateOnLeave() {
        state = "On Leave";
    }

    public void setStateWorking() {
        state = "Working";
    }

    public void addLeaveRecord(Leave leave) {
        LeaveRecords.add(leave);
    }

    // Getters and Setters
    public ArrayList<Leave> getLeaveRecords() {
        return LeaveRecords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getState() {
        return state;
    }

}
