// LinkedList.java *******
package Lab4_LinkedListProject2.LinkedListUpdated;

public class LinkedList {
    // head isa reference variable (i.e. class variable) to the first node of the list

    private LLnode head;

    // CONSTRUCTORS
    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;  //If head is null, it returns true otherwise false
    }

    public int FindLargest() {
        return FindLargest(head);
    }

    private int FindLargest(LLnode head) {
        LLnode helpPtr = head;
        int largest = head.getData();
        while (helpPtr != null) {
            if (helpPtr.getData() > largest) {
                largest = helpPtr.getData();
            }
            helpPtr = helpPtr.getNext();
        }

        return largest;
    }


    public boolean search(int data) { //Gets only the data to be searched, from calling method
        return search(head, data); //Sends reference to the first node and the data to be searched, 
        //to another overloaded ‘Search’ method, which will return
        //‘true’ if that data is found, otherwise it will return false
    }
    //
    // boolean | search(LLnode, int)
    //

    private boolean search(LLnode p, int data) { //Gets reference of first node and data to be 
        //searched, from calling method(Previous
        //Search method) and returns Boolean value
        LLnode helpPtr = p;  //Assigns received reference to another reference variable ‘helpPtr’
        while (helpPtr != null) {
            if (helpPtr.getData() == data) {  //If data is found
                return true;
            }
            helpPtr = helpPtr.getNext();  //Goes to next node in the list
        }
        return false;  //If data is not found after traversing the entire link list
    }

    //
    // boolean | findNode(int)
    //
    public LLnode findNode(int data) { //Gets the ‘data’ to be searched
        return findNode(head, data); //Calls another method findNode() by passing it the 
        //reference variable ‘head’ and the data to be found
    }
    //
    // boolean | findNode(LLnode, int) //Used for finding the required data
    // This method has not been used in this program

    private LLnode findNode(LLnode p, int data) { //Receives reference variable for traversing 
        //the entire link list and the data to be found
        LLnode helpPtr = p;  //Assigns received reference to another reference variable ‘helpPtr’
        while (helpPtr != null) {   //Traverses the entire link list
            if (helpPtr.getData() == data) { //If the required data is found
                return helpPtr;                       //Returns reference i.e. pointer to that node
            }
            helpPtr = helpPtr.getNext(); //For moving to next node
        }
        return null;  //If required data is not found
    }

    //
    // void | PrintList()
    //


    public void PrintList() {
        PrintList(head);  //Calling another method PrintList() by passing it reference variable 
        //‘head’ for traversing the entire link list
    }
    //
    // void | PrintList(LLnode)
    //

    private void PrintList(LLnode head) { //Receives reference variable for traversing
        // We need to traverse...so we need a help pointer
        LLnode helpPtr = head;

        while (helpPtr != null) {
            // Print the data value of the node
            System.out.print(helpPtr.getData() + ", ");
            // Moving to next node
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }

    //
    // void | ModifyAllNodes()
    //
    public void ModifyAllNodes() {
        ModifyAllNodes(head); //Passing reference variable to another method
    }
    //
    // void | ModifyAllNodes(LLnode)
    //

    private void ModifyAllNodes(LLnode head) { //Takes reference variable
        // We need to traverse...so we need a help pointer
        LLnode helpPtr = head;   //Assigns reference of first node to some other reference 
        //variable ‘helpPtr’ which will be used to traverse the link list
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // We add 10 to the data value of each node
            helpPtr.setData(helpPtr.getData() + 10); //Adding 10 to the data field of each node
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
    }

    //
    // int | sumNodes()
    //


    public int sumNodes() {  //It will be used to find the sum of all data elements of all nodes
        return sumNodes(head); //Passing reference variable to another method
    }
    //
    // int | sumNodes(LLnode) //For finding the sum of all nodes.
    //This method has not been used here

    private int sumNodes(LLnode head) {
        // We need to traverse...so we need a help ptr
        LLnode helpPtr = head;  //Assigns reference of first node to some other reference 
        //variable ‘helpPtr’ which will be used to traverse the link list

        int sum = 0; // Variable for holding the sum of all data elements
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Increase sum
            sum += helpPtr.getData();
            // Step one node over
            helpPtr = helpPtr.getNext(); //Moves to next node
        }
        return sum;
    }

    //
    // void | insert(int)
    //
    public void insert(int data) { //Takes only data to be inserted
        head = insert(head, data); //Calls another insert() method by passing it the reference 
        //variable ‘head’ (pointing to first node) for traversing the link
        //list and the data to be inserted at the proper location
    }
    //
    // LLnode | insert(LLnode, value)
    //

    private LLnode insert(LLnode head, int data) { //Receives reference variable and data
        // IF there is no list, newNode will be the first node, so just return it
        if (head == null || head.getData() > data) {//If head is null i.e. there is no node or if there
            //is only one node whose data is greater than
            //the data we want to insert (as we want an
            //ascending ordered data)
            head = new LLnode(data, head); //Creates new node with data and reference variable
            //head which was previously null (if there was no
            //node) or pointing to the previously existing
            //only node and then assigns its address to the reference variable ‘head’ so that
            //head will be pointing to this newly created node which has now become the
            //first node in the list i.e. it will always add new node to the front of link list
            return head;
        } // ELSE, we have a list. Insert the new node at the correct location

        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            LLnode helpPtr = head;

            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) { //Traversing the entire link list
                if (helpPtr.getNext().getData() > data) { //if data of next (i.e. successor) node is 
                    //greater than the data we want to insert after the current node
                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            LLnode newNode = new LLnode(data, helpPtr.getNext()); //Creates a newNode and 
            //sets its ‘next’ field to point to the successor node
            helpPtr.setNext(newNode); //Making predecessor node (which helpPtr points to) point 
            //to the newly created node
        }
        // Return head
        return head;
    }

    //
    // void | delete(int)
    //
    public void delete(int data) { //Takes data to be deleted
        head = delete(head, data);//Passes the reference variable ‘head’ for traversing the entire 
        //link list and data to be deleted. It will return the reference of
        //the next node
    }
    //
    // LLnode | delete(LLnode, value)
    //

    private LLnode delete(LLnode head, int data) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty()) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            if (head.getData() == data) {
                head = head.getNext(); //Head will now point to the next node in the list
            } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and 
            //look for it
            else {
                // We need to traverse to find the data we want to delete...so we need a help ptr
                LLnode helpPtr = head; //reference variable helpPtr will be used to traverse and 
                //delete the required node
                // Traverse to correct deletion point

                while (helpPtr.getNext() != null) {
                    if (helpPtr.getNext().getData() == data) {//Comparing the data of next node 
                        //(successor of current node) with the
                        //data to be deleted
                        helpPtr.setNext(helpPtr.getNext().getNext()); //Skipping the deleted node
                        break; // we deleted the value and should break out of the while loop
                    }
                    helpPtr = helpPtr.getNext();
                } //End of while
            } //End of else part
            // return the possibly updated head of the list
            return head; //Returns reference of the first node
        } //End of outer most if 
        return head; //If list becomes empty, it returns null as the value of reference variable ‘head’
    }

    //Method to return data of second node in the list
    public int Data2ndNode() {
        return Data2ndNode(head);
    }

    //Write code to 
    // -find, if list contains only one node, then display the message "Cannot find data of second node; list has only one node
    // -otherwise return data of second node in the list
    private int Data2ndNode(LLnode head) {


        return 0; //remove this statement after writing your code
    }

    //Method to return data of second last node in the list
    public int Data2ndLastNode() {
        return Data2ndLastNode(head);
    }

    //Write code to 
    // -find, if list contains only one node, then display the message "Cannot find data of second last node; list has only one node
    // -otherwise traverse every node of the list and return the data of second last node in the list
    private int Data2ndLastNode(LLnode head) {


        return 0; //remove this statement after writing your code
    }

    //Method to delete last node in the list
    public void DeleteLast() {
        head = DeleteLast(head);
    }


    //Write code to 
    // -find, if list contains only one node, then delete that node
    // -otherwise traverse every node of the list and delete last node in the list
    private LLnode DeleteLast(LLnode head) {


        return null; //Remove this statement after writing your code
    }


    //Method to convert all odd value nodes into even value nodes in the list and vice versa 
    public void Odd2Even2Odd() {
        Odd2Even2Odd(head);
    }


    //Write code to 
    // -traverse each and every node in the list
    // -find if data of visited node is even, change it into odd by adding 1 into it
    // -otherwise change it into even by subtracting 1 from it
    private void Odd2Even2Odd(LLnode head) {


    }

}
