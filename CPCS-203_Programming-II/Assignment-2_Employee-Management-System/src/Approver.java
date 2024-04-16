import java.time.LocalDate;

public interface Approver {

    public void  approveLeave (Employee employee, LocalDate date, int id);

    public void markEmployeeAsWorking(Employee employee);
}
