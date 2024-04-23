/*
Name: Abdulrahman Adnan Thigah
*/
package Lab7_InheritanceAndPolymorphism;

public class MotivationalBook extends Book {

    private final double discountRate = 0.10;

    public MotivationalBook() {
        super();
    }

    public MotivationalBook(String name, double cost) {
        super(name, cost);
    }

    @Override
    public double getPurchasesCost() {
        return super.getPurchasesCost() * (1 - discountRate);
    }

    @Override
    public String toString() {
        return "Motivational Book Title: " + getTitle() + ", Purchase' Cost: " + super.getPurchasesCost()
                + ", Cost after discount = " + getPurchasesCost();
    }
}
