/*
Name: Abdulrahman Adnan Thigah
*/
package Lab7_InheritanceAndPolymorphism;

public class ChildrenBook extends Book{
    private double discountRate = 0.15; // 15%
    public ChildrenBook() {
        super();
    }
    public ChildrenBook (String name, double cost) {
        super(name, cost);
    }


}
