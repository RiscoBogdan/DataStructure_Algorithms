package DataStructure_Algorithms.Trees.BinarySearchTree_BST;

//Sorted Tree (Binary Search Tree) rule: Right child > root OR node > Left child

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    int curentSize;
    private Node root;

    public MyTree() {
        root = null;
        curentSize = 0;
    }

    public static void main(String[] args) {
        MyTree bt = new MyTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(7);
        bt.add(9);
        bt.add(5);
        bt.add(3);
        System.out.print("Pre Order = root->left->right: ");
        bt.travPreOrder(bt.root);
        System.out.println("\n");
        System.out.print("In Order = left->root->right: ");
        bt.travInOrder(bt.root);
        System.out.println("\n");
        System.out.print("Post Order = left->right->root: ");
        bt.travPostOrder(bt.root);
        System.out.print("\nBreadth First Search: ");
        bt.BreadthFirstSearch(bt.root);
        System.out.print("\nContains: "+ bt.contains2(3, bt.root));

    }

    // Depth - First Search  DFS:  1.PRE ORDER --- 2.IN ORDER --- 3.POST ORDER
    public void travPreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(" " + node.data);
        travPreOrder(node.left);
        travPreOrder(node.right);

    }

    public void travInOrder(Node node) {
        if (node != null){
            travInOrder(node.left);
            System.out.print(" " + node.data);
            travInOrder(node.right);
        }
    }

    public void travPostOrder(Node node) {
        if (node == null) return;

        travPostOrder(node.left);
        travPostOrder(node.right);
        System.out.print(" " + node.data);

    }

    //Breadth - First Search  BFS
    public void BreadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            System.out.print(temp.data + " ");
        }
    }

    public boolean contains2(int data, Node node){
        if(node == null) return false;
        if(data == node.data) return true;

        if(data < node.data){
            return contains2(data, node.left);
        }
        return contains2(data,node.right);
    }
    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            curentSize++;
            return;
        }
        insertion(data, root);
        curentSize++;
    }

    private void insertion(int data, Node node) {
       if(data > node.data){
           if(node.right == null){
               node.right = new Node(data);
              return;
           }
           insertion(data, node.right);
           return;
       }
       if(node.left == null){
           node.left = new Node(data);
           return;
       }
        insertion(data, node.left);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

}
