/* 
Abdulrahman Thigah
*/

import java.time.LocalDate;

public class Manager extends Employee implements Approver {

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.15;
    }

    @Override
    public void approveLeave(Employee employee, LocalDate date, int id) {
        Leave leave = new Leave(employee, date, id);
        employee.addLeaveRecord(leave);
        employee.setStateOnLeave();
    }

    @Override
    public void markEmployeeAsWorking(Employee employee) {
        employee.setStateWorking();
    }

}
