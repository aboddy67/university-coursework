/* 
Course : CPCS 204
Name : Abdulrahman Thigah
Section : C11
Name of lab instructor : Ayman Yafoz
Assignment number :  #1
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("\nWelcome to Linked List Program\n");
        int userChoice = 0;
        int TimeoutCounter = 0;

        do {
            System.out.println("What would you like to try? \nChoose a command from the list: ");
            System.out.println( "| 0. Exit Program                                                      |\n" +
                                "| 1. Delete n nodes after skipping m nodes                             |\n" +
                                "| 2. Swap k'th node from beginning with k'th node from end             |\n" +
                                "| 3. Sort the intersection given two singly-linked lists of integers   |\n" +
                                "| 4. Sort a doubly linked list in increasing order                     |\n");

            System.out.print("Choice: ");
            userChoice = input.nextInt();


            switch (userChoice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("\nCreating Linked List for Delete test...");
                    int[] keysForDelete = getArrayFromUser();
                    LLnode head = initializeSinglyLinkedList(keysForDelete);

                    System.out.println();
                    printSinglyLinkedList(head); // to show original list
                    System.out.println();

                    System.out.print("Enter m: ");
                    int m = input.nextInt();
                    System.out.print("Enter n: ");
                    int n = input.nextInt();
                    deleteNodes(head, m, n);
                    System.out.println("\nDONE!");
                    printSinglyLinkedList(head);
                    System.out.println("---------------\n");
                    break;
                case 2:
                    System.out.println("\nCreating Linked List for Swap test...");
                    int[] keysForSwap = getArrayFromUser();
                    head = initializeSinglyLinkedList(keysForSwap);

                    System.out.println();
                    printSinglyLinkedList(head); // to show original list
                    System.out.println();

                    System.out.print("Enter k: ");
                    int k = input.nextInt();

                    swapNodes(head, k);
                    System.out.println("\nDONE!");
                    printSinglyLinkedList(head);
                    System.out.println("---------------\n");
                    break;

                case 3:
                    System.out.println();

                    System.out.println("\nCreating X Linked List...");
                    int[] keysX = getArrayFromUser();
                    LLnode headX = initializeSinglyLinkedList(keysX);

                    System.out.println("\nCreating Y Linked List...");
                    int[] keysY = getArrayFromUser();
                    LLnode headY = initializeSinglyLinkedList(keysY);

                    System.out.println();
                    System.out.print("X: ");
                    printSinglyLinkedList(headX); // to show original list for X
                    System.out.print("Y: ");
                    printSinglyLinkedList(headY); // to show original list for Y
                    System.out.println();

                    LLnode headOutput = sortedIntersect(headX, headY);
                    System.out.println("\nDONE!");
                    printSinglyLinkedList(headOutput);
                    System.out.println("---------------\n");
                    break;

                case 4:
                    System.out.println("\nCreating Linked List for Sort test...");
                    int[] keysForSort = getArrayFromUser();
                    LLnode headSort = initializeDoublyLinkedList(keysForSort);

                    System.out.println();
                    printDoublyLinkedList(headSort); // to show original list
                    System.out.println();

                    headSort = DoublySortAscending(headSort);

                    System.out.println("\nDONE!");
                    printDoublyLinkedList(headSort);
                    System.out.println("---------------\n");
                    break;

                default:
                    System.out.println("Invalid Command, Please try again!");
                    // fail case for too much invalid inputs
                    TimeoutCounter++;
                    System.out.println();

            }
        } while (userChoice != 0 && TimeoutCounter != 3);

    }
    // -------------------------------------------------------------------------------------
    // Problem Number: 1

    public static LLnode deleteNodes(LLnode head, int m, int n) {
        // Fail case: if the list is empty or m or n is non-positive
        if (head == null || m <= 0 || n <= 0) {
            return head;
        }

        LLnode current = head; // Start from head

        // Loop to check all nodes
        while (current != null) {
            // Skip m nodes
            for (int i = 1; i < m && current != null; i++) {
                current = current.getNext();
            }

            // If we reached the end of the list, break
            if (current == null) {
                break;
            }

            // Delete the next n nodes
            LLnode temp = current.getNext();
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.getNext();
            }

            // Link the current node to the node after the deleted nodes
            current.next = temp;

            // Move to the next node
            current = temp;
        }

        // Return the head after changes
        return head;
    }

    // -------------------------------------------------------------------------------------
    // Problem Number: 2

    public static LLnode swapNodes(LLnode head, int k) {
        // Check if the list is empty or k is non-positive
        if (head == null || k <= 0) {
            return head; // Invalid input
        }

        // Initialize pointers for the k-th nodes and their previous nodes
        LLnode first = null, second = null;
        LLnode prevFirst = null, prevSecond = null;
        LLnode current = head;

        int length = 0;

        // Step 1: Find the k-th node from the beginning and compute list length
        while (current != null) {
            length++;
            if (length == k) {
                first = current;
            }
            current = current.next;
        }

        // If k is out of bounds, return the head as is
        if (first == null) {
            return head;
        }

        // Step 2: Find the k-th node from the end
        int endPos = length - k + 1;
        current = head;
        int index = 1;

        while (current != null) {
            if (index == endPos) {
                second = current;
            }
            if (index == endPos - 1) {
                prevSecond = current;
            }
            if (index == k - 1) {
                prevFirst = current;
            }
            current = current.next;
            index++;
        }

        // If k is out of bounds, return the head as is
        if (second == null) {
            return head;
        }

        // Step 3: Swap only the links (without swapping data)
        if (first == second) {
            return head; // No swap needed if both nodes are the same
        }

        // Swap the previous nodes' next pointers
        if (prevFirst != null) {
            prevFirst.next = second;
        } else {
            head = second; // Update head if first node is the head
        }

        if (prevSecond != null) {
            prevSecond.next = first;
        } else {
            head = first; // Update head if second node is the head
        }

        // Swap the next pointers of the first and second nodes
        LLnode temp = first.next;
        first.next = second.next;
        second.next = temp;

        // Return the head after changes
        return head;
    }

    // -------------------------------------------------------------------------------------
    // Problem Number: 3

    public static LLnode sortedIntersect(LLnode X, LLnode Y) {
        // Check if either list is empty
        if (X == null || Y == null) {
            return null; // No intersection if one of the lists is empty
        }

        LLnode head = null;
        LLnode tail = null;

        // Traverse both lists
        while (X != null && Y != null) {
            if (X.getData() == Y.getData()) {
                LLnode newNode = new LLnode(X.getData(), null);

                // If this is the first common element, set both head and tail to the new node
                if (head == null) {
                    head = tail = newNode;
                } else {
                    // Otherwise, append to the end of the list and update tail
                    tail.next = newNode;
                    tail = newNode;
                }

                X = X.getNext();
                Y = Y.getNext();
            } else if (X.getData() < Y.getData()) {
                X = X.getNext();
            } else {
                Y = Y.getNext();
            }
        }

        return head;
    }

    // -------------------------------------------------------------------------------------
    // Problem Number: 4
    public static LLnode DoublySortAscending(LLnode head) {
        // Base case: if the list is empty or has one node
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves using the slow and fast pointer method
        LLnode slow = head;
        LLnode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Midpoint will be the node next to 'slow', and we split the list
        LLnode mid = slow.next;
        slow.next = null; // Disconnect the first half from the second half

        // Recursively sort both halves
        LLnode left = DoublySortAscending(head);
        LLnode right = DoublySortAscending(mid);

        // Merge the two sorted halves
        LLnode mergedHead = null;
        LLnode tail = null;

        // Merge the sorted lists
        while (left != null && right != null) {
            LLnode nextNode;
            if (left.data <= right.data) {
                nextNode = left;
                left = left.next;
            } else {
                nextNode = right;
                right = right.next;
            }

            if (mergedHead == null) {
                mergedHead = tail = nextNode;
            } else {
                tail.next = nextNode;
                nextNode.prev = tail;
                tail = nextNode;
            }
        }

        // If there are remaining nodes in the left list
        while (left != null) {
            if (mergedHead == null) {
                mergedHead = tail = left;
            } else {
                tail.next = left;
                left.prev = tail;
                tail = left;
            }
            left = left.next;
        }

        // If there are remaining nodes in the right list
        while (right != null) {
            if (mergedHead == null) {
                mergedHead = tail = right;
            } else {
                tail.next = right;
                right.prev = tail;
                tail = right;
            }
            right = right.next;
        }

        return mergedHead;
    }
    // -------------------------------------------------------------------------------------
    //
    // HELPER METHODS
    //
    // -------------------------------------------------------------------------------------
    public static void printSinglyLinkedList(LLnode head) {
        LLnode current = head;
        while (current != null) {

            System.out.print(current.getData() + " —> ");
            current = current.getNext();
        }
        // indicate end of list
        System.out.println("null");
    }

    // ------------------------------------------------------------------------------------
    public static void printDoublyLinkedList(LLnode head) {
        LLnode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ⇔ ");
            current = current.getNext();
        }
        // Indicate the end of the list
        System.out.println("null");
    }

    // ------------------------------------------------------------------------------------
    public static LLnode initializeSinglyLinkedList(int[] keys) {
        // Create the linked list from the array of keys
        LLnode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            // Create a new node with the current key and link it to the head
            head = new LLnode(keys[i], head);
        }
        return head;
    }

    // ------------------------------------------------------------------------------------
    public static LLnode initializeDoublyLinkedList(int[] keys) {
        LLnode head = null;
        LLnode lastNode = null; // Keep track of the last node to set the 'prev' pointer

        for (int i = keys.length - 1; i >= 0; i--) {
            LLnode newNode = new LLnode(keys[i], head, null);
            if (head != null) {
                head.prev = newNode; // Set the prev pointer of the current head
            }
            head = newNode; // Update head to the new node
        }

        return head;
    }

    // ------------------------------------------------------------------------------------
    public static int[] getArrayFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in Linked list: ");
        int size = scanner.nextInt(); // Get the size of the array
        int[] numbers = new int[size]; // Create the array

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt(); // Fill the array with user input
        }
        return numbers; // Return the filled array
    }

}
