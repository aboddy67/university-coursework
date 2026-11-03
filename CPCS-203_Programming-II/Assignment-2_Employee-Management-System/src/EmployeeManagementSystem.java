/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeManagementSystem {
    // used to store the employees,
    private final ArrayList<Employee> employees;

    // -----------------------------------------------------------------------------------------------------
    // Constructor to initialize the created variables to avoid NullPointerException
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    // -----------------------------------------------------------------------------------------------------
    // Method to add an employee to the list with checking the type of employee using instanceof
    public String addEmployee(Employee addedEmployee) {
        employees.add(addedEmployee);
        String title = "";

        // check what type of employee
        if (addedEmployee instanceof Manager) {
            title = "Manager";
        } else if (addedEmployee instanceof Developer) {
            title = "Developer";
        } else if (addedEmployee instanceof Designer) {
            title = "Designer";
        }

        return title + " " + addedEmployee.getName() + " added.";
    }

    // -----------------------------------------------------------------------------------------------------
    // Method to remove an employee from the list while checking for the existence
    public String removeEmployee(int id) {
        Employee chosenEmployee = findEmployeeById(id);

        if (chosenEmployee == null) {
            return "Employee with ID " + id + " not found.";
        }
        employees.remove(chosenEmployee);
        return "Employee removed successfully.";
    }

    // -----------------------------------------------------------------------------------------------------
    // Method to print a list of all employees with their salaries and bonuses
    public String printAllEmployees() {
        StringBuilder employeePlan = new StringBuilder();
        String format = "%-15s %-6s%-12s%-12s%n";
        String formatWithSalary = "%-15s %-6s%8.2f%11.2f%n";

        employeePlan.append(String.format(format,
                "Name ", "ID", "Salary", "Bonus"));

        for (Employee employee : employees) {
            employeePlan.append(String.format(formatWithSalary,
                    employee.getName(), employee.getId(), employee.getSalary(), employee.calculateBonus()));
        }

        return employeePlan.toString();
    }

    // -----------------------------------------------------------------------------------------------------
    // method to approve leave for an employee with checking the manager authority and the employee existence
    public String approveLeave(int managerId, int employeeId, LocalDate startDate, int days) {

        Employee chosenManager = findEmployeeById(managerId);
        Employee chosenEmployee = findEmployeeById(employeeId);

        if (!(chosenManager instanceof Approver) || chosenEmployee == null) {
            return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
        }

        if ((chosenEmployee.getState() != null) && (!chosenEmployee.getState().equalsIgnoreCase("On Leave"))) {
            ((Manager) chosenManager).approveLeave(chosenEmployee, startDate, days);
        } else {
            return "Cannot approve leave for " + chosenEmployee.getName() + " as they are already on leave.";
        }


        return "Leave approved for " + chosenEmployee.getName() + ".";
    }

    // -----------------------------------------------------------------------------------------------------
    // Method to mark an employee as working with checking the manager authority and the employee existence
    public String markEmployeeAsWorking(int managerId, int employeeId) {

        Employee chosenManager = findEmployeeById(managerId);
        Employee chosenEmployee = findEmployeeById(employeeId);

        if (!(chosenManager instanceof Approver) || chosenEmployee == null) {
            return "Mark Employee as Working failed. Either manager ID is incorrect or employee ID does not exist.";
        }

        if ((chosenEmployee.getState() != null) && !(chosenEmployee.getState().equalsIgnoreCase("Working"))) {
            Manager manager = (Manager) chosenManager;
            manager.markEmployeeAsWorking(chosenEmployee);
        } else {
            return "Marking Employee as Working Failed. Employee is already Working.";
        }

        return "Employee " + chosenEmployee.getName() + " is now marked as working.";
    }

    // -----------------------------------------------------------------------------------------------------
    // Method to print all the leave records for a specific employee
    public String printEmployeeLeaveRecords(int employeeId) {
        Employee employee = findEmployeeById(employeeId);
        StringBuilder printLeaveRecords = new StringBuilder();

        // check for any null employees to avoid NullPointerException
        if (employee == null) {
            return "Employee with ID " + employeeId + " not found.";
        }
        printLeaveRecords.append("Leave records for " + employee.getName() + ":\n");

        String format = "%-13s%-13s%n";
        printLeaveRecords.append(String.format(format, "Start Date", "Days of leave"));

        for (Leave leave : employee.getLeaveRecords()) {
            printLeaveRecords.append(String.format(format, leave.getStartDate(), leave.getDaysOfLeave()));
        }

        return printLeaveRecords.toString();
    }

    // -----------------------------------------------------------------------------------------------------
    // Internal Method to find an employee by their ID, and only for private use
    private Employee findEmployeeById(int id) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
// -----------------------------------------------------------------------------------------------------

} // End Class
