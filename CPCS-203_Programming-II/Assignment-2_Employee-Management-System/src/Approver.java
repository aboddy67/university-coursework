/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

import java.time.LocalDate;

// Interface for Approver adds more capabilities to the manager
public interface Approver {

    public void  approveLeave (Employee employee, LocalDate date, int id);

    public void markEmployeeAsWorking(Employee employee);
}
