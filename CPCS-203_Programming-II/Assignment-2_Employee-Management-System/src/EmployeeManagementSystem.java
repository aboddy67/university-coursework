/* 
Abdulrahman Thigah
*/

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;

// -----------------------------------------------------------------------------------------------------
    // ---------------------------- MAIN METHOD ----------------------------
    public static void main(String[] args) {

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
    public String approveLeave(int mangerId, int employeeId, LocalDate startDate, int days) {


        return "";
    }
// -----------------------------------------------------------------------------------------------------
    public String markEmployeeAsWorking(int id) {

        return "";
    }
// -----------------------------------------------------------------------------------------------------
    public String printEmployeeLeaveRecords(int id) {

        return "";
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
