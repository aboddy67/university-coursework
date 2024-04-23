/* 
Abdulrahman Thigah
*/
package Lab5_ThinkingInObjects;

import java.util.Scanner;

public class ProductInfoTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("The total number of Products: " + Product.getCount());
        System.out.println("##############################################");

        Product prod1 = new Product("Smartphone", "John", "Doe", 2021);

        System.out.println("Enter product title: ");
        String productTitle = in.next();

        System.out.println("Enter first and last name of the Customer: ");
        String firstName, lastName;
        firstName = in.next(); lastName = in.next();

        System.out.println("Enter year: ");
        int manufacturingYear = in.nextInt();

        Product prod2 = new Product(productTitle, firstName, lastName, manufacturingYear);

        Product prod3 = new Product("Laptop", new Person("Jane","Smith"), 2022);


        System.out.println("##########Productss information########## ");
        System.out.println(prod1.toString());
        System.out.println(prod2.toString());
        System.out.println(prod3.toString());

        System.out.println("##############################################");
        System.out.println("The total number of Products: " + Product.getCount());
    }
}
