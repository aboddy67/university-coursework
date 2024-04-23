/* 
Abdulrahman Thigah
*/
package Lab10_Generics;

public class Pair <T> {

    private T Element;

    public Pair (T Element) {
        this.Element = Element;
    }

    // Getters and Setters
    public T getElement() {
        return Element;
    }

    public void setElement(T element) {
        Element = element;
    }
    public void displayElement() {
        System.out.println(Element);
    }
}
