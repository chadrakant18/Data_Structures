class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BST {

    Node root;

    // INSERT
    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // SEARCH
    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // INORDER
    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // PREORDER
    public void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // POSTORDER
    public void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // FIND MINIMUM
    public Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // DELETE
    public Node delete(Node root, int val) {

        if (root == null) {
            return null;
        }

        if (val < root.data) {
            root.left = delete(root.left, val);
        }

        else if (val > root.data) {
            root.right = delete(root.right, val);
        }

        else {

            // Case 1: Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One Child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two Children
            Node inorderSuccessor = findMin(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right, inorderSuccessor.data);
        }

        return root;
    }

    // COUNT NODES
    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // HEIGHT
    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        BST tree = new BST();

        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }

        System.out.println("Inorder:");
        tree.inorder(tree.root);

        System.out.println("\nSearch 6:");
        System.out.println(tree.search(tree.root, 6));

        System.out.println("Height:");
        System.out.println(tree.height(tree.root));

        System.out.println("Count:");
        System.out.println(tree.countNodes(tree.root));

        tree.root = tree.delete(tree.root, 5);

        System.out.println("After deleting 5:");
        tree.inorder(tree.root);
    }
}