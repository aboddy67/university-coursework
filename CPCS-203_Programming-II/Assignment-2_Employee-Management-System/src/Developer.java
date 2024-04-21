/*
Name: Abdulrahman Adnan Thigah
Section: CS7
Program No: 2
*/

// Developer Employee class with its own bonus calculation
public class Developer extends Employee {

    public Developer(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.12;
    }

}
