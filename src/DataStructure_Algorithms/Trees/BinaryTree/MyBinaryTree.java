package DataStructure_Algorithms.Trees.BinaryTree;
//Unsorted Tree
import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    static int currentSize;
    private Node root;
    public MyBinaryTree() {
        root = null;
        currentSize = 0;
    }
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public void Delete(Node node, int data){
        if(node == null) return;
        if(node.right == null && node.left == null){
            if(node.data == data){
                return;
            }
            return;
        }
//find the item we want to delete
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node temp = null, foundNode = null;
        while (!queue.isEmpty()) {
              temp = queue.poll();

              if(temp.data == data){
                 foundNode = temp;
                 break; // stop
              }

              if(temp.left != null){
                  queue.add(temp.left);
              }
              if(temp.right != null) {
                  queue.add(temp.right);
              }
        }
        if(foundNode != null){
            int saveTempData = temp.data;
            deleteDepest(root ,temp);
            foundNode.data = saveTempData;
        }
    }
    //find the deepest item in the Binary Tree
    public void deleteDepest(Node root,Node delNode)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Do level order traversal until last node
        while (!q.isEmpty())
        {
           Node temp = q.poll();

            if (temp == delNode)
            {
                temp = null;
                return;

            }
            if (temp.right!=null)
            {
                if (temp.right == delNode)
                {
                    temp.right = null;
                    return;
                }
                else
                    q.add(temp.right);
            }

            if (temp.left != null)
            {
                if (temp.left == delNode)
                {
                    temp.left = null;
                    return;
                }
                else
                    q.add(temp.left);
            }
        }
    }

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            currentSize++;
            return;
        }
        insertion(data, root);
        currentSize++;
    }
   //Iterative insertion using Queue , like a Breadth First Search
    public void insertion(int data, Node node) {
        //using queue
        Node newNode = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.left == null) {
                temp.left = newNode;
                return;
            }
            queue.add(temp.left);

            if(temp.right == null){
                temp.right = newNode;
                return;
            }
            queue.add(temp.right);
        }
    }


    public static void main(String[] args) {
        MyBinaryTree myTree = new MyBinaryTree();
        myTree.add(5);
        myTree.add(15);
        myTree.add(10);
        myTree.add(12);
        myTree.add(13);
        myTree.add(7);
        myTree.InOrderIteration(myTree.root);
        System.out.println(currentSize);
    }

    public void InOrderIteration(Node node){
        if(node == null) return;
        InOrderIteration(node.left);
        System.out.println(" "+ node.data);
        InOrderIteration(node.right);
    }

}
