/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

import java.time.LocalDate;

// Leave class to add leave details to the employee's leave record
public class Leave {
    private Employee employee;
    private LocalDate startDate;
    private int daysOfLeave;

    public Leave(Employee employee, LocalDate startDate, int daysOfLeave) {
        this.employee = employee;
        this.startDate = startDate;
        this.daysOfLeave = daysOfLeave;

    }

    public String displayLeaveDetails() {
        return startDate + "\t" + daysOfLeave;
    }

    public int getDaysOfLeave() {
        return daysOfLeave;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
