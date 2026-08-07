/*package AVL;
public class AVLTree {

    AVLNode root;


    int height(AVLNode node){

        if(node == null)
            return 0;

        return node.height;
    }


    int getBalance(AVLNode node){

        if(node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

}*/
package AVL;

import Sales.*;

public class AVLTree {

    private AVLNode root;

    // Return the height of a node
    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    // Update the height of a node
    private void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(
                getHeight(node.left),
                getHeight(node.right)
        );
    }

    // Calculate the balance factor
    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    // Right rotation
    private AVLNode rotateRight(AVLNode unbalancedNode) {

        AVLNode newRoot = unbalancedNode.left;
        AVLNode temporaryNode = newRoot.right;

        newRoot.right = unbalancedNode;
        unbalancedNode.left = temporaryNode;

        updateHeight(unbalancedNode);
        updateHeight(newRoot);

        return newRoot;
    }

    // Left rotation
    private AVLNode rotateLeft(AVLNode unbalancedNode) {

        AVLNode newRoot = unbalancedNode.right;
        AVLNode temporaryNode = newRoot.left;

        newRoot.left = unbalancedNode;
        unbalancedNode.right = temporaryNode;

        updateHeight(unbalancedNode);
        updateHeight(newRoot);

        return newRoot;
    }

    // Public insert method
    public void insert(int id, Sales sales) {
        root = insertNode(root, id, sales);
    }

    // Recursive insert method
    private AVLNode insertNode(AVLNode node, int id, Sales sales) {

        // Normal BST insertion
        if (node == null) {
            return new AVLNode(id, sales);
        }

        if (id < node.id) {
            node.left = insertNode(node.left, id, sales);
        } else if (id > node.id) {
            node.right = insertNode(node.right, id, sales);
        } else {
            System.out.println("Sales ID already exists: " + id);
            return node;
        }

        // Update height
        updateHeight(node);

        // Check balance
        int balance = getBalance(node);

        // Left Left case
        if (balance > 1 && id < node.left.id) {
            return rotateRight(node);
        }

        // Right Right case
        if (balance < -1 && id > node.right.id) {
            return rotateLeft(node);
        }

        // Left Right case
        if (balance > 1 && id > node.left.id) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left case
        if (balance < -1 && id < node.right.id) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Public search method
    public Sales search(int id) {

        AVLNode result = searchNode(root, id);

        if (result == null) {
            return null;
        }

        return result.sales;
    }

    // Recursive search method
    private AVLNode searchNode(AVLNode node, int id) {

        if (node == null || node.id == id) {
            return node;
        }

        if (id < node.id) {
            return searchNode(node.left, id);
        }

        return searchNode(node.right, id);
    }

    // Public delete method
    public void delete(int id) {
        root = deleteNode(root, id);
    }

    // Recursive delete method
    private AVLNode deleteNode(AVLNode node, int id) {

        if (node == null) {
            System.out.println("Sales ID not found: " + id);
            return null;
        }

        // Find the node
        if (id < node.id) {
            node.left = deleteNode(node.left, id);
        } else if (id > node.id) {
            node.right = deleteNode(node.right, id);
        } else {

            // Node has no child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Node has only right child
            if (node.left == null) {
                return node.right;
            }

            // Node has only left child
            if (node.right == null) {
                return node.left;
            }

            // Node has two children
            AVLNode successor = getMinimumNode(node.right);

            node.id = successor.id;
            node.sales = successor.sales;

            node.right = deleteNode(node.right, successor.id);
        }

        // Update height
        updateHeight(node);

        // Check balance
        int balance = getBalance(node);

        // Left Left case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left Right case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Right case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Right Left case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Find the smallest node
    private AVLNode getMinimumNode(AVLNode node) {

        AVLNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Inorder traversal
    public void inorder() {
        System.out.println("Inorder traversal:");
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(AVLNode node) {

        if (node != null) {
            inorderTraversal(node.left);

            System.out.print(node.id + " ");

            inorderTraversal(node.right);
        }
    }

    // Preorder traversal
    public void preorder() {
        System.out.println("Preorder traversal:");
        preorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(AVLNode node) {

        if (node != null) {
            System.out.print(node.id + " ");

            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Postorder traversal
    public void postorder() {
        System.out.println("Postorder traversal:");
        postorderTraversal(root);
        System.out.println();
    }

    private void postorderTraversal(AVLNode node) {

        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);

            System.out.print(node.id + " ");
        }
    }

    // Check whether the tree is empty
    public boolean isEmpty() {
        return root == null;
    }
}