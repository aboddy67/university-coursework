/* 
Abdulrahman Thigah
*/

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeManagementSystem {
    private final ArrayList<Employee> employees;

    // -----------------------------------------------------------------------------------------------------
    // Constructor to initialize the created variables
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    // -----------------------------------------------------------------------------------------------------
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
    public String removeEmployee(int id) {
        Employee chosenEmployee = findEmployeeById(id);

        if (chosenEmployee == null) {
            return "Employee with ID " + id + " not found.";
        }
        employees.remove(chosenEmployee);
        return "Employee removed successfully.";
    }

    // -----------------------------------------------------------------------------------------------------
    public String printAllEmployees() {
        StringBuilder employeePlan = new StringBuilder();
        String format = "%-15s %-6s%-12s%-12s%n";
        String formatWithSalary = "%-15s %-6s%8.2f%11.2f%n";

        employeePlan.append(String.format(format, "Name ", "ID", "Salary", "Bonus"));

        for (Employee employee : employees) {
            employeePlan.append(String.format(formatWithSalary,
                    employee.getName(), employee.getId(), employee.getSalary(), employee.calculateBonus()));
        }

        return employeePlan.toString();
    }

    // -----------------------------------------------------------------------------------------------------
    public String approveLeave(int managerId, int employeeId, LocalDate startDate, int days) {

        Employee chosenManager = findEmployeeById(managerId);
        Employee chosenEmployee = findEmployeeById(employeeId);

        if (!(chosenManager instanceof Manager) || chosenEmployee == null) {
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
    public String markEmployeeAsWorking(int managerId, int employeeId) {

        Employee chosenManager = findEmployeeById(managerId);
        Employee chosenEmployee = findEmployeeById(employeeId);

        if (!(chosenManager instanceof Manager) || chosenEmployee == null) {
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
    public String printEmployeeLeaveRecords(int employeeId) {
        Employee employee = findEmployeeById(employeeId);
        StringBuilder printLeaveRecords = new StringBuilder();

        printLeaveRecords.append("Leave records for " + employee.getName() + ":\n");

        String format = "%-13s%-13s%n";
        printLeaveRecords.append(String.format(format, "Start Date", "Days of leave"));

        for (Leave leave : employee.getLeaveRecords()) {
            printLeaveRecords.append(String.format(format, leave.getStartDate(), leave.getDaysOfLeave()));
        }

        return printLeaveRecords.toString();
    }

    // -----------------------------------------------------------------------------------------------------
    private Employee findEmployeeById(int id) {
        Employee correctEmployee = null;

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
// -----------------------------------------------------------------------------------------------------

}
