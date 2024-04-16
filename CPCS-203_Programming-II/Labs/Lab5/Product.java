/* 
Abdulrahman Thigah
*/
package Lab5;

public class Product {
    private String productName;
    private Person Customer;
    private int manufacturingYear;
    private static int count = 0; // to store the total number of product objects created

    public Product(String productName, String firstName, String lastName, int manufacturingYear) {
        this.productName = productName;
        this.manufacturingYear = manufacturingYear;
        Customer = new Person(firstName, lastName);
        count++;
    }

    public Product(String productName, Person Customer, int manufacturingYear) {
        this.productName = productName;
        this.Customer = Customer;
        this.manufacturingYear = manufacturingYear;

        count++;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Person getCustomer() {
        return Customer;
    }

    public void setCustomer(Person Customer) {
        this.Customer = Customer;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    @Override
    public String toString() {

        return productName + ", " + Customer + ", " + manufacturingYear;
    }
    public static int getCount() {
        return count;
    }
}
