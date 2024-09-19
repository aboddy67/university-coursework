/* 
Abdulrahman Thigah
*/

import org.w3c.dom.Node;

import java.util.LinkedList;

public class Problem_1 {
    public static void main(String[] args) {
        // Example list: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> 9 —> 10 —> null
        int[] keys = {1, 2, 3, 4};

        // Create the linked list from the array of keys
        LLnode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            // Create a new node with the current key and link it to the head
            head = new LLnode(keys[i], head);

        }
        printList(head);


        printList(head);
    }



    // -------------------------------------------------------------------------------------
    public static void printList(LLnode head) {
        LLnode current = head;  // Start with the head of the list
        while (current != null) {
            // Print the data of the current node, followed by an arrow
            System.out.print(current.getData() + " —> ");
            current = current.getNext();  // Move to the next node
        }
        System.out.println("null");  // Print null to indicate the end of the list
    }
    // ------------------------------------------------------------------------------------
}
