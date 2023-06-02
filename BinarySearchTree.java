import java.util.*;

public class BinarySearchTree {
    
    static class Node {
        int data;
        Node left, right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    Node root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    // Insert a node into the BST
    public void insert(int data) {
        root = insertNode(root, data);
    }
    
    private Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }
        
        return root;
    }
    
    // Traverse the BST in preorder
    public void preorder() {
        preorderTraversal(root);
    }
    
    private void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    
    // Traverse the BST in inorder
    public void inorder() {
        inorderTraversal(root);
    }
    
    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    
    // Traverse the BST in postorder
    public void postorder() {
        postorderTraversal(root);
    }
    
    private void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    // Traverse the BST in levelorder
    public void levelorder() {
        if (root == null) {
            return;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    
    // Count the number of nodes in the BST
    public int countNodes() {
        return countNodes(root);
    }
    
    private int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    // Count the number of leaves in the BST
    public int countLeaves() {
        return countLeaves(root);
    }
    
    private int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return countLeaves(root.left) + countLeaves(root.right);
    }
    
    // Find the height of the BST
    public int height() {
        return findHeight(root);
    }
    
    private int findHeight(Node root) {
        if (root == null) {
            return -1;
        }
        
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        
       
    return Math.max(leftHeight, rightHeight) + 1;
}

// Search for an item in the BST
public boolean search(int data) {
    return searchNode(root, data);
}

private boolean searchNode(Node root, int data) {
    if (root == null) {
        return false;
    }
    
    if (root.data == data) {
        return true;
    } else if (data < root.data) {
        return searchNode(root.left, data);
    } else {
        return searchNode(root.right, data);
    }
}

// Remove a node from the BST
public void remove(int data) {
    root = removeNode(root, data);
}

private Node removeNode(Node root, int data) {
    if (root == null) {
        return root;
    }
    
    if (data < root.data) {
        root.left = removeNode(root.left, data);
    } else if (data > root.data) {
        root.right = removeNode(root.right, data);
    } else {
        // Case 1: No child
        if (root.left == null && root.right == null) {
            root = null;
        }
        
        // Case 2: One child
        else if (root.left == null) {
            root = root.right;
        } else if (root.right == null) {
            root = root.left;
        }
        
        // Case 3: Two children
        else {
            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = removeNode(root.right, temp.data);
        }
    }
    
    return root;
}

private Node findMin(Node node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}

// Test the BST class
public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    
    bst.insert(50);
    bst.insert(30);
    bst.insert(20);
    bst.insert(40);
    bst.insert(70);
    bst.insert(60);
    bst.insert(80);
    
    System.out.println("Preorder Traversal:");
    bst.preorder();
    System.out.println("\n");
    
    System.out.println("Inorder Traversal:");
    bst.inorder();
    System.out.println("\n");
    
    System.out.println("Postorder Traversal:");
    bst.postorder();
    System.out.println("\n");
    
    System.out.println("Levelorder Traversal:");
    bst.levelorder();
    System.out.println("\n");
    
    System.out.println("Number of Nodes: " + bst.countNodes());
    System.out.println("Number of Leaves: " + bst.countLeaves());
    System.out.println("Height of the Tree: " + bst.height());
    
    int searchItem = 70;
    if (bst.search(searchItem)) {
        System.out.println(searchItem + " is found in the BST");
    } else {
        System.out.println(searchItem + " is not found in the BST");
    }
    
    int removeItem = 20;
    bst.remove(removeItem);
    System.out.println(removeItem + " is removed from the BST");
    
    System.out.println("Inorder Traversal after removing " + removeItem + ":");
    bst.inorder();
}
}