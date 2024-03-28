/*
Name: Abdulrahman Adnan Thigah
*/
package Lab7_InheritanceAndPolymorphism;

public class Book {
    private String title;
    private double purchasesCost;

    public Book() {
        this.title = "";
        this.purchasesCost = 0.0;
    }
    public Book(String title, double purchasesCost) {
        this.title = title;
        this.purchasesCost = purchasesCost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPurchasesCost() {
        return purchasesCost;
    }

    public void setPurchasesCost(double purchasesCost) {
        this.purchasesCost = purchasesCost;
    }

    public String toString() {
        return "Title: " + title + ", Purchase' Cost: " + purchasesCost;
    }
}
