/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

import java.time.LocalDate;

// Manager Employee class Having Approver implementation
public class Manager extends Employee implements Approver {
// -----------------------------------------------------------------------------------------------------
    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }
// -----------------------------------------------------------------------------------------------------
    @Override
    public double calculateBonus() {
        return getSalary() * 0.15;
    }
// -----------------------------------------------------------------------------------------------------
    // Approve Leave method, adds a leave object to the employee's leave record
    // and sets the employee's state to on leave
    @Override
    public void approveLeave(Employee employee, LocalDate date, int id) {
        Leave leave = new Leave(employee, date, id);
        employee.addLeaveRecord(leave);
        employee.setStateOnLeave();
    }
// -----------------------------------------------------------------------------------------------------
    @Override
    public void markEmployeeAsWorking(Employee employee) {
        employee.setStateWorking();
    }

}
