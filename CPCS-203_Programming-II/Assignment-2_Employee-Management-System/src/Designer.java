/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

// Designer Employee class with its own bonus calculation
public class Designer extends Employee {

    public Designer(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10;
    }
}
