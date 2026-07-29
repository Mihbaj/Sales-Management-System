package BST;

public class AVLTree {

    private Node root;

    // Node class
    private static class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    // Get height of a node
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Return maximum value
    private int max(int a, int b) {
        return Math.max(a, b);
    }

    // Get balance factor
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // Right Rotation
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = 1 + max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    // Left Rotation
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = 1 + max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    // Public Insert
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive Insert
    private Node insert(Node node, int key) {

        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // RR
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // LR
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RL
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Public Delete
    public void delete(int key) {
        root = delete(root, key);
    }

    // Recursive Delete
    private Node delete(Node node, int key) {

        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);

        } else if (key > node.key) {
            node.right = delete(node.right, key);

        } else {

            if (node.left == null || node.right == null) {

                Node temp;

                if (node.left != null) {
                    temp = node.left;
                } else {
                    temp = node.right;
                }

                node = temp;

            } else {

                Node successor = getMinimumNode(node.right);
                node.key = successor.key;
                node.right = delete(node.right, successor.key);

            }
        }

        if (node == null) {
            return null;
        }

        node.height = 1 + max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // LR
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RR
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // RL
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Find minimum node
    private Node getMinimumNode(Node node) {

        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Search
    public boolean search(int key) {

        Node current = root;

        while (current != null) {

            if (key == current.key) {
                return true;
            }

            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // Inorder Traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {

        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Preorder Traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {

        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder Traversal
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {

        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}



