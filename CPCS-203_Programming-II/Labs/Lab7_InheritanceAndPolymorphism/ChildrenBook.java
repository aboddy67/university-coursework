/*
Name: Abdulrahman Adnan Thigah
*/
package Lab7_InheritanceAndPolymorphism;

public class ChildrenBook extends Book {

    private double discountRate = 0.15; // 15%

    public ChildrenBook() {
        super();
    }

    public ChildrenBook(String name, double cost) {
        super(name, cost);
    }

    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * (1 - discountRate);
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + ", Purchase' Cost: " + super.getPurchasesCost()
                + ", Cost after discount = " + getPurchasesCost();
    }
}
