package DataStructure_Algorithms.Stack;

import java.util.EmptyStackException;


public class StackWithLinkedList {
    public Node head;
    public Node top;

    public StackWithLinkedList(){
        head = top = null;
    }
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }


    public static void main(String[] args) {
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        stack.pop();
        stack.iterate();
    }

    //methods

    public void push(int data){
        Node node = new Node(data);
        if(head == null){
            head = top = node;
            return;
        }
        top.next = node;
        top = node;

    }

    public void pop(){
        if(head == null){
            throw new EmptyStackException();
        }
        if(head.next == null){
            head = null;
            top = null;
            return;
        }

        Node previous = head;
        Node current = head.next;
        while(current != null){
            previous = current;
            current = current.next;
        }
        previous = top;
        top.next = previous.next = null;
//        return previous.data;
    }


    public void iterate(){
        Node counter = head;
        while(counter != null){
            System.out.println(counter.data);
            counter = counter.next;
        }

    }
}
