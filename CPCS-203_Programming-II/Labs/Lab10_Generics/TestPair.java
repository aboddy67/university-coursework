/* 
Abdulrahman Thigah
*/
package Lab10_Generics;

public class TestPair {
    public static void main(String[] args) {

        // Create the objects with initialization
        Pair<String> string = new Pair<>("apple");
        Pair<Integer> integer = new Pair<>(10);

        // Print Them using their print methods
        System.out.println("Pair: ");

        System.out.print("First: ");
        string.displayElement();

        System.out.print("Second: ");
        integer.displayElement();
    }
}
