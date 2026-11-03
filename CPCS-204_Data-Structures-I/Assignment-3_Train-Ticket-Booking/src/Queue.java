/*
Course: CPCS 204
Name: Abdulrahman Thigah
Section: CS11
Name of lab instructor: Ayman Yafoz
Assignment number: #3
*/

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // -------------------------------------------------------
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // -------------------------------------------------------
    public T dequeue() {
        // edge case for empty queue so we cant dequeue
        if (isEmpty()) return null;

        T outData = front.data;
        front = front.next;
        return outData;
    }

    // -------------------------------------------------------
    public boolean isEmpty() {
        return front == null;
    }

    // -------------------------------------------------------
    // show front of queue without removing
    public Node<T> peak() {
        return front;
    }
    // -------------------------------------------------------
}
