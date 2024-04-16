/* 
Abdulrahman Thigah
*/

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employees;

    public static void main(String[] args) {

        // MAIN

    }

    public EmployeeManagementSystem() {

    }

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

    public String removeEmployee(int id) {
        boolean flag = false;

        for (Employee chosenEmployee : employees) {
            if (chosenEmployee.getId() == id) {
                employees.remove(chosenEmployee);
                flag = true;
                break;
            }
        }

        if (flag == false) {
            System.out.println("Remove failed. ID is incorrect or employee ID does not exist.");
        }

        return "Employee removed successfully ";
    }

    public String printAllEmployees() {
        StringBuilder employeePlan = new StringBuilder();
        employeePlan.append("Name "+ "\t" + "ID" + "\t" + "Salary" +  "\t" + "Bonus");
        employeePlan.append("\n");

        for (Employee employee : employees) {
            employeePlan.append(employee.getName() + "\t" + employee.getId() + "\t" + employee.getSalary() + "\t" + employee.calculateBonus());
            employeePlan.append("\n");
        }


        return employeePlan.toString();
    }

    public String approveLeave(int mangerId, int employeeId, LocalDate startDate, int days) {


        return "";
    }
    public String markEmployeeAsWorking(int id) {

        return"";
    }
    public String printEmployeeLeaveRecords (int id) {

        return"";
    }
    private Employee findEmployeeById (int id) {

        return null;
    }
}
