/* 
Abdulrahman Thigah
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private final ArrayList<Employee> employees;

    // -----------------------------------------------------------------------------------------------------
    // ---------------------------- MAIN METHOD ----------------------------
    public static void main(String[] args) throws FileNotFoundException {
        File employmentManagementFile = new File("input.txt");
        File outputFile = new File("output.txt");
        if(!outputFile.exists() && !employmentManagementFile.exists()) {
            System.out.println("One or more files are not found!");
            System.exit(0);
        }
        PrintWriter pw = new PrintWriter(outputFile);
    }

    // -----------------------------------------------------------------------------------------------------
    public void handleInputCommands(File f) throws FileNotFoundException {
        Scanner in = new Scanner(f);

    }
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
            title = "Manger";
        } else if (addedEmployee instanceof Developer) {
            title = "Developer";
        } else if (addedEmployee instanceof Designer) {
            title = "Designer";
        }

        return title + addedEmployee.getName() + "added.";
    }

    // -----------------------------------------------------------------------------------------------------
    public String removeEmployee(int id) {
        Employee chosenEmployee = findEmployeeById(id);

        if (chosenEmployee == null) {
            return "Remove failed. ID is incorrect or ID does not exist";
        }
        employees.remove(chosenEmployee);
        return "Employee removed successfully ";
    }

    // -----------------------------------------------------------------------------------------------------
    public String printAllEmployees() {
        StringBuilder employeePlan = new StringBuilder();
        employeePlan.append("Name " + "\t" + "ID" + "\t" + "Salary" + "\t" + "Bonus");
        employeePlan.append("\n");

        for (Employee employee : employees) {
            employeePlan.append(employee.getName() + "\t" + employee.getId() + "\t" + employee.getSalary() + "\t" + employee.calculateBonus());
            employeePlan.append("\n");
        }


        return employeePlan.toString();
    }

    // -----------------------------------------------------------------------------------------------------
    public String approveLeave(int managerId, int employeeId, LocalDate startDate, int days) {

        Employee manager = findEmployeeById(managerId);
        Employee employee = findEmployeeById(employeeId);

        if (manager instanceof Manager) {

            if (employee != null) {

                if (!employee.getState().equalsIgnoreCase("On Leave")) {

                    ((Manager) manager).approveLeave(employee, startDate, days);

                } else {
                    return "Cannot approve leave for " + employee.getName() + " as they are already on leave.";
                }
            }
        } else {
            return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
        }

        return "Leave approved for " + employee.getName();
    }


    // -----------------------------------------------------------------------------------------------------
    public String markEmployeeAsWorking(int managerId, int employeeId) {

        Employee chosenManager = findEmployeeById(managerId);
        Employee chosenEmployee = findEmployeeById(employeeId);

        if (chosenManager instanceof Manager) {

            if (chosenEmployee != null) {

                if (!chosenEmployee.getState().equalsIgnoreCase("Working")) {
                    Manager manager = (Manager) chosenManager;
                    manager.markEmployeeAsWorking(chosenEmployee);
                } else {
                    return "Marking Employee as Working Failed. Employee is already Working.";
                }
            }
        } else {
            return "Mark Employee as Working failed. Either manager ID is incorrect or employee ID does not exist.";
        }

        return "Employee " + chosenEmployee.getName() + " is now marked as working.";
    }

    // -----------------------------------------------------------------------------------------------------
    public String printEmployeeLeaveRecords(int employeeId) {
        Employee employee = findEmployeeById(employeeId);
        StringBuilder printLeaveRecords = new StringBuilder();

        printLeaveRecords.append("Leave Records for " + employee.getName());
        printLeaveRecords.append("\n");
        printLeaveRecords.append("Start Date" + "\t" + "Days of leave");

        for (Leave leave : employee.getLeaveRecords()) {
            leave.displayLeaveDetails();
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
