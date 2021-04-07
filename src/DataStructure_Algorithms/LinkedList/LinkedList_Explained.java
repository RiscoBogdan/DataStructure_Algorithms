package DataStructure_Algorithms.LinkedList;

//addSortedNodeAsc() - in plus
public class LinkedList_Explained{
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
            currentSize++;
        }

        public int getData() {
            return data;
        }
        public Node getNext() {
            return next;
        }
    }
  private  Node head;

    public static void main(String[] args) {
        LinkedList_Explained List = new LinkedList_Explained();
        List.head = new Node(1);
        Node second = new Node(3);
        Node third = new Node(5);
        List.head.next = second;
        second.next = third;
        List.addSortedNodeAsc(0);
        List.addSortedNodeAsc(0);
        List.addSortedNodeAsc(2);

//        List.head = new Node(1);//trebuie sa fac un head in lista
//        //pe urma fac un Node sau mai multi si ii link-uiesc intre ei
//        Node second = new Node(2);
//        Node third = new Node(3);
//        Node forth = new Node(4);
        //Acum ii link-uiesc intre ei leg data cu null-ul
//        List.head.next = second;
//        second.next = third;
//        third.next = forth;
//        List.addElementAfterANode(6, third);
//        List.addElementAtFront(4);
//        System.out.println("Total Nodes in LinkedList: " + List.printList());
        List.printList();

    }

    public void addSortedNodeAsc(int value){
        //find insertion point
        Node node = new Node(value);
        if(head==null || head.data >= value){
            node.next = head;
            head = node;
            return;
        }
        Node current = head.next;
        Node previous = head;

        while(current != null && current.data < value){
            previous = current;
            current = current.next;
        }
        node.next = current;
        previous.next = node;
    }
    //print from head and print all elements
    public void printList() {
        Node n = head;//print from head

//        int count = 0;
        while (n != null) {
            System.out.println(n.data);
//            count++;
            n = n.next;
        }
        System.out.println("Currenet size: "+ currentSize);

    }

    public void printHead() {
        Node h = head;
        if (h != null) {
            System.out.println(head.data);
        } else {
            System.out.println("Head is null!");
        }
    }

    public void printLastNext() {
        Node lastNext = head;
        while (lastNext != null) {
            lastNext = lastNext.next;
        }
        if (lastNext == null) {
            System.out.println("True is null!");
        } else {
            System.out.println("Is not null!");
        }
    }

    //method to insert a new node at the HEAD of the list (at the front)
    public void addElementAtFront(int new_data) {
        //1 alocate new data from the head in list
        Node newHead = new Node(new_data);
        //2 link it with existing head
        newHead.next = head;
        //3 make it the head
        head = newHead;
        currentSize++;
    }

    public void addElementAfterANode(int new_data, Node prev_Node) {
        if (prev_Node == null) {
            System.out.println("Previous node is null, it can't be null!");
        }
        //Allocate new memory for new node
        Node new_Node = new Node(new_data);
        new_Node.next = prev_Node.next;
        prev_Node.next = new_Node;


    }

    public void addLast(int data) {
        Node D = new Node(data);
        Node tmp = head;
        if (head == null) {
            head = D;
            return;
        }
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = D;
        D.next = null;

    }


    public static int currentSize;
    public LinkedList_Explained(){
        head = null;
        currentSize=0;
    }
}
