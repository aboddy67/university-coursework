/* 
Abdulrahman Thigah
*/
import java.util.ArrayList;

public abstract class Employee {
    private String name;
    private int id;
    private double salary;
    private String state;
    private ArrayList <Leave> LeaveRecords;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.state = "Working";
        LeaveRecords = new ArrayList<>();
    }

    // so that each employee implements the bonus accordingly
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

    public ArrayList<Leave> getLeaveRecords() {
        return LeaveRecords;
    }

    // getters and setters for attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setState(String state) {
        this.state = state;
    }
}
