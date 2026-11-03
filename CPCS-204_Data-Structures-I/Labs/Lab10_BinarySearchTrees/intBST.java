package Lab10_BinarySearchTrees;// intBST.java
// Author: 
// 
// Class from which we can create fully functional BSTs

public class intBST {
    private BSTnode root;//root as reference variable

    // CONSTRUCTORS
    public intBST() {
        root = null;
    }

    /* Below are MANY methods that are used on Binary Search Trees.
     *
     * Examples:
     * search, insert, delete, isEmpty, minVal, maxVal, inorder, sumNodes, and many more
     */


    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return root == null;// returns true if BST is empty
    }


    //
    // boolean | search(int)
    //This method will be used to search a node in the entire BST
    public boolean search(int data) {
        return search(root, data);//Passing data to be searched and
        //the reference variable ‘root’ to the method
    }

    //
    // boolean | search(BSTnode, int)
    //
    private boolean search(BSTnode p, int data) {
        if (p == null)//No Subtree
            return false;
        else {
            // if the data we are searching for is found at p (at the current root)
            if (data == p.getData())
                return true;
// if the data we are searching for is less than p (i.e the current root), we // shall search it in left subtree

            else if (data < p.getData())
                return search(p.getLeft(), data);
// if the data we are searching for is greater than p (i.e the current root), //we  shall search it in right subtree

            else
                return search(p.getRight(), data);
        }
    }


    //
    // void | insert(int)
    //
    public void insert(int data) {
        BSTnode newNode = new BSTnode(data);//Create new node
        //containing the given data
        root = insert(root, newNode);//Reference variable ‘root’ will //be used to search proper place in the tree to insert ‘newNode’
    }

    //
    // BSTnode | insert(BSTnode, BSTnode)
    //
    private BSTnode insert(BSTnode p, BSTnode newNode) {
        // IF there is no tree, newNode will become the root, so just return it
        if (p == null)
            return newNode;

            // ELSE, we have a tree. Insert to the right or the left
        else {
            // Insert to the RIGHT of root
            if (newNode.getData() > p.getData()) {
                // Recursively insert into the right subtree
                // The result of insertion is an updated root of the right subtree
                BSTnode temp = insert(p.getRight(), newNode);
                // Save this newly updated root of right subtree into p.right
                p.setRight(temp); //i.e. p.Right = temp;
            }
            // Insert to the LEFT of root
            else {
                // Recursively insert into the left subtree
                // The result of insertion is an updated root of the left subtree
                BSTnode temp = insert(p.getLeft(), newNode);
                // Save this newly updated root of left subtree into p.left
                p.setLeft(temp); //i.e. p.Left = temp;
            }
        }
        // Return root of updated tree
        return p;
    }


    //
    // void | inorder()
    //
    public void inorder() {
        inorder(root);
    }

    //
    // void | inorder(BSTnode)
    //
    private void inorder(BSTnode p) {
        if (p != null) {
            inorder(p.getLeft());//When this call is finished,
            //current node’s data is printed
            System.out.print(p.getData() + ", ");
            inorder(p.getRight());//When this call is finished,
//this function call is removed from the stack
        }
    }


    //
    // int | sumNodes()
    //
    public int sumNodes() {
        return sumNodes(root);
    }

    //
    // int | sumNodes(BSTnode)
    //
    private int sumNodes(BSTnode p) {
        if (p != null)
            return p.getData() + sumNodes(p.getLeft()) + sumNodes(p.getRight());
        else
            return 0;
    }


    //
    // void | delete(int)
    //
    public void delete(int data) {
        root = delete(root, data);
    }

    //
    // BSTnode | delete(BSTnode, int)
    //
    private BSTnode delete(BSTnode p, int data) {
        BSTnode node2delete, newnode2delete, node2save, parent;
        int saveValue;

        // Step 1: Find the node we want to delete
        node2delete = findNode(p, data);
        // If node is not found (does not exist in tree), we clearly cannot delete it.
        if (node2delete == null)
            return root;//No change in root

        // Step 2: Find the parent of the node we want to delete, //whose reference is now contained in ‘node2delete’ (after using findNode() //method)
        parent = parent(p, node2delete);//Here ‘p’ will contain //reference of root node  and ‘node2delete’ will contain reference of node to //be deleted

        // Step 3: Perform Deletion based on three possibilities

        // **1** :  node2delete is a leaf node
        if (isLeaf(node2delete)) {
            // if parent is null, this means that node2delete is the ONLY node in the tree
            if (parent == null)
                return null; // we return null as the updated //root of the tree (after deleting the only node i.e. root in the tree)

            // Delete node if it is a left child
            if (data < parent.getData())
                parent.setLeft(null);
                // Delete node if it is a right child
            else
                parent.setRight(null);

            // Finally, return the root of the tree (in case the root got updated)
            return p;
        }

        // **2** : node2delete has only a left child
        if (hasOnlyLeftChild(node2delete)) {
            // if node2delete is the root
            if (parent == null)
                return node2delete.getLeft();

            // If node2delete is not the root,
            // it must be left OR right child of some node

            // IF it is the left child of some node
            if (data < parent.getData())
                parent.setLeft(parent.getLeft().getLeft());
                // ELSE it is the right child of some node
            else
                parent.setRight(parent.getRight().getLeft());

            // Finally, return the root of the tree (in case the root got updated)
            return p;
        }

        // **3** :  node2delete has only a right child
        if (hasOnlyRightChild(node2delete)) {
            // if node2delete is the root
            if (parent == null)
                return node2delete.getRight();

            // If node2delete is not the root,
            // it must be left OR right child of some node

            // IF it is the left child of some node
            if (data < parent.getData())
                parent.setLeft(parent.getLeft().getRight());
                // ELSE it is the right child of some node
            else
                parent.setRight(parent.getRight().getRight());

            // Finally, return the root of the tree (in case the root got updated)
            return p;
        }

        // **4** :If node2delete has TWO children.
        // then, we have two choices: the minVal from the right subtree (of the deleted node)
        // or the maxVal from the left subtree (of the deleted node)
        // We choose to find the minVal from the right subtree.
        newnode2delete = minNode(node2delete.getRight());
        // Now we need to temporarily save the data value(s) from this node
        saveValue = newnode2delete.getData();

        // Now, we recursively call our delete method to actually delete this node that we just copied the data from
        p = delete(p, saveValue);  ////////////////////////

        // Now, put the saved data (in saveValue) into the correct place (the original node we wanted to delete)
        node2delete.setData(saveValue);

        // Finally, return the root of the tree (in case the root got updated)
        return p;
    }


    //
    // BSTnode | minNode(BSTnode)
    // Minimum value will be obtained by visiting only the left subtree
    public BSTnode minNode(BSTnode root) {
        if (root == null) {
            return null;//if BST or left subtree is empty
        } else {
            if (root.getLeft() == null) {
                return root;//If there is no left child of current root,
                //then current root is the minimum node
            } else {
                return minNode(root.getLeft());//Keep moving to left subtree
            }
        }
    }


    //
    // BSTnode | maxNode(BSTnode)
    // Maximum value will be obtained by visiting only the rightsubtree
    public BSTnode maxNode(BSTnode root) {
        if (root == null) {
            return null;
        } else {
            if (root.getRight() == null) {
                return root;//If there is no right child of current root,
                //then current root is the maximum node

            } else {
                return maxNode(root.getRight());//Keep moving to right
                //subtree
            }
        }
    }


    //
    // BSTnode | findNode(int)
    //This method will be used to find the parent of some node, or to
    //delete any node
    public BSTnode findNode(int data) {
        return findNode(root, data);
    }

    //
    // BSTnode | findNode(BSTnode, int)
    //
    private BSTnode findNode(BSTnode p, int data) {
        if (p == null)
            return null;
        else {
            // if the data we are searching for is found at p (at
            // the current root)
            if (data == p.getData())
                return p;
            else if (data < p.getData())
                return findNode(p.getLeft(), data);
            else
                return findNode(p.getRight(), data);
        }
    }

    //
    // BSTnode | parent(BSTnode)
    //
    public BSTnode parent(BSTnode p) {
        return parent(root, p);
    }

    //
    // BSTnode | parent(BSTnode, BSTnode)
    //
    private BSTnode parent(BSTnode root, BSTnode p) {
        //Here initially root will contain reference (of root node)
        //stored in p and p will contain reference of node to be
        //deleted (or whose parent is to be found) found by the
        //findNode() method
// Take care of NULL cases
        if (root == null || root == p)
            return null; // because there is no parent

        // If root is the actual parent of node p
        if (root.getLeft() == p || root.getRight() == p)
            return root; // because root is the parent of p

        // Look for p's parent in the left side of root
        if (p.getData() < root.getData())
            return parent(root.getLeft(), p);

            // Look for p's parent in the right side of root
        else if (p.getData() > root.getData())
            return parent(root.getRight(), p);

            // Take care of any other cases
        else
            return null;
    }


    //
    // boolean | isLeaf(BSTnode)
    //
    public Boolean isLeaf(BSTnode p) {
        return (p.getLeft() == null && p.getRight() == null);
    }


    //
    // boolean | hasOnlyLeftChild(BSTnode)
    //
    public Boolean hasOnlyLeftChild(BSTnode p) {
        return (p.getLeft() != null && p.getRight() == null);
    }


    //
    // boolean | hasOnlyRightChild(BSTnode)
    //
    public Boolean hasOnlyRightChild(BSTnode p) {
        return (p.getLeft() == null && p.getRight() != null);
    }

    public int heightBST() {
        return heightBST(root);
    }

    //
    // int | heightBST()
    //
    private int heightBST(BSTnode p) {
        int leftHeight, rightHeight;
        if (p == null)
            //return 0;
            return -1;


        leftHeight = heightBST(p.getLeft());

        rightHeight = heightBST(p.getRight());

        if (leftHeight > rightHeight)
            return leftHeight + 1;

        return rightHeight + 1;


        //return Math.max(heightBST(p.getLeft()), heightBST(p.getRight())+1);


    }


    //
    // void | postorder()
    //
    public void postorder() {
        postorder(root);
    }

    //
    // void | postorder(BSTnode)
    //
    private void postorder(BSTnode p) {
        //Type your code (postorder method) here
        if (p != null) {
            postorder(p.getLeft());  // Traverse left subtree
            postorder(p.getRight()); // Traverse right subtree
            System.out.print(p.getData() + ", "); // Visit node
        }
    }


    //
    // void | descendingorder()
    //
    public void descendingorder() {
        descendingorder(root);
    }

    //
    // void | descendingorder(BSTnode)
    //
    private void descendingorder(BSTnode p) {
        //Type your code (descendingorder method) here
        if (p != null) {
            descendingorder(p.getRight()); // Traverse right subtree
            System.out.print(p.getData() + ", "); // Visit node
            descendingorder(p.getLeft()); // Traverse left subtree
        }
    }


    //
    // int | count7()
    //
    public int count7() {
        return count7(root);
    }

    //
    // int | count7(BSTnode)
    //
    private int count7(BSTnode p) {
        //Type your code (count7 method) here
        if (p == null) {
            return 0;
        }
        int count = 0;
        if (p.getData() % 7 == 0) {
            count = 1;
        }
        return count + count7(p.getLeft()) + count7(p.getRight());
    }


    //
    // void | modifyAllNodes(int)
    //
    public void modifyAllNodes(int v) {
        modifyAllNodes(root, v);
    }

    //
    // void | modifyAllNodes(BSTnode)
    //
    private void modifyAllNodes(BSTnode p, int v) {
        //Type your code (modifyAllNodes method) here
        if (p != null) {
            p.setData(p.getData() + v); // Modify the current node's data
            modifyAllNodes(p.getLeft(), v); // Traverse left subtree
            modifyAllNodes(p.getRight(), v); // Traverse right subtree
        }
    }


}
	
