public class BinaryTree {
    Node root;

    public void add(int key, String fName, String lName, String pNumber, String address, String city, String state) {
        Node newNode = new Node(key, fName, lName, pNumber, address, city, state);

        if(root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while(true) {
                parent = focusNode;

                if(key < focusNode.key) { // if the key is less than the current node, go to the left node
                    focusNode = focusNode.leftChild;

                    if(focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else { // go on the right node since key is larger than current node
                    focusNode = focusNode.rightChild;

                    if(focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
        /*
        - Adds nodes into binary tree
        - Parameters are the key and the data that is stored in node
        - Returns void
         */
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraversal(focusNode.rightChild);
        }
        /*
        - Does an in order traversal
        - Parameter is starting node
        - Returns void
         */
    }

    public void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);

            preOrderTraversal(focusNode.leftChild);

            preOrderTraversal(focusNode.rightChild);
        }
        /*
        - Does a pre order traversal
        - Parameter is starting node
        - Returns void
         */
    }
    public void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);

            postOrderTraversal(focusNode.rightChild);

            System.out.println(focusNode);

        }
        /*
        - Does a post order traversal
        - Parameter is starting node
        - Returns void
         */
    }

    public Node search(int key) {
        Node focusNode = root;

        while(focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return null;
            }
        }
        return  focusNode;
        /*
        - Search through tree for node with specific key
        - Parameter is the key for the node we're looking for
        - Returns the node if found, else returns null
         */
    }

    public boolean delete(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        while(focusNode.key != key) {
            parent = focusNode;

            if(key < focusNode.key) {
                isLeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isLeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null) {
                return false;
            }
        }
        if(focusNode.leftChild == null && focusNode.rightChild == null) {
            if(focusNode == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if(focusNode.rightChild == null) {
            if(focusNode == root) {
                root = focusNode.leftChild;
            } else if(isLeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else if(focusNode.leftChild == null) {
            if(focusNode == root) {
                root = focusNode.rightChild;
            } else if(isLeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else {
            Node replacement = getReplacementNode(focusNode);

            if(focusNode == root) {
                root = replacement;
            } else if(isLeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;
        }
        return true;
        /*
        - Removes a node from tree
        - Parameter is the key for node to be removed
        - Returns a boolean if the node has been removed
         */
    }

    public Node getReplacementNode(Node replaceNode) {
        Node replacementParent = replaceNode;
        Node replacement = replaceNode;

        Node focusNode = replaceNode.rightChild;

        while(focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        if(replacement != replaceNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replaceNode.rightChild;
        }
        return replacement;
        /*
        - Moves around BST to connect nodes correctly
        - The parameter is the focus node
        - Returns replacement node
         */
    }
}
