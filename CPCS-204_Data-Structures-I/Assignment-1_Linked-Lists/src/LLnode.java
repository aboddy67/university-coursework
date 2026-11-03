/* 
Abdulrahman Thigah
*/

public class LLnode {
    int data;
    LLnode next;
    LLnode prev;

    // Constructor for the singly linked list node
    LLnode(int data, LLnode next) {
        this.data = data;
        this.next = next;
    }

    // Constructor for the doubly linked list node
    LLnode(int data, LLnode next, LLnode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public LLnode getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}
