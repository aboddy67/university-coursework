/* 
Abdulrahman Thigah
*/

public class Developer extends Employee {

    public Developer(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.12;
    }

}
