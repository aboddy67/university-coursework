/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Assignment number: #3
*/

public class Stack<T> {
    private Node<T> top;

    // -------------------------------------------------------
    public Stack() {
        this.top = null;
    }

    // -------------------------------------------------------
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    // -------------------------------------------------------
    public T pop() {
        // edge case if stack is empty so can't remove
        if (isEmpty()) return null;

        T poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // -------------------------------------------------------
    public boolean isEmpty() {
        return top == null;
    }

    // -------------------------------------------------------
    // show top of stack without removing
    public Node<T> top() {
        return top;
    }
    // -------------------------------------------------------
}
