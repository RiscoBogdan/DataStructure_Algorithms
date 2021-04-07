package DataStructure_Algorithms.LinkedList;
//Available Methods
//***********************//
//addFirst() - O(1)
//addLast() - O(n)
//addLastWithTail() - O(1)

//deleteFirst() - O(1)
//deleteLast() - O(n)

//peekFirst() - O(1)
//peekLastWithTail() - O(1)
//peekLast() - O(n)

//addAfterAnElement() - O(n) with index

//addNodeAfterAnExistingNode() - O(n) with Node static so we can create

//removeAfterAnElement() - O(n) removes the elements after the given index and links element at index with current.next element


//printList();
//***********************//

public class LinkedList<E> {
    private static int currentSize;  //keeps track of size of the list
    //End of creating a node
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        head = null;
        currentSize = 0;
    }

    public static void main(String[] args) {
//        LinkedList<Integer> myElements = new LinkedList<>();
//        myElements.addFirst(5);
//        myElements.addFirst(4);
//        myElements.addFirst(10);
//        myElements.addFirst(6);
//        myElements.addLast(12);
//        myElements.addAfterAnElement(14, 5);
//        myElements.printList();
//        myElements.deleteLast();
//        System.out.println("size " + currentSize);
//        System.out.println(myElements.peekFirst());
//        System.out.println(myElements.peekLast());
//        System.out.println("List");

        LinkedList<Integer> List = new LinkedList<>();
        List.addFirst(1);
        List.addLast(2);
        List.addLast(8);
        List.addLast(6);
        List.addFirst(3);
        List.addLast(2);
        List.addLast(8);
        List.addAfterAnElement(99, 7);
        List.addFirst(100);
        List.addLastWithTail(9);
        List.deleteLast();
        List.printList();
        System.out.println("Last with tail: " + List.peekLastWithTail()); //O(1)
    }

    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public E peekLast() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head.data;
        }
        Node<E> previous = head;
        Node<E> current = head.next;
        while (current != null) {
            previous = current;
            current = current.next;
        }
        return previous.data;

    }

    //With tail i could peekLast with O(1) Time Complexity
    public E peekLastWithTail() {
        if (tail == null) return null;
        return tail.data;
    }

    //addFirst();  head - null
    public void addFirst(E data) {
        Node<E> node = new Node<>(data);
        node.next = head; //ce am in head am si in noul node.next
        head = node; //am in head node-ul nou
        currentSize++;
    }

    public void addLast(E data) { //O(n)
        Node<E> node = new Node<>(data);
        Node<E> startFromHead = head;
        if (head == null) {
            head = node;
            tail = node;
            currentSize++;
            return;
        }
        while (startFromHead.next != null) {
            startFromHead = startFromHead.next;
        }
        startFromHead.next = node;
        tail = node;
        //node.next = null;//when we create a node, its next already points to null
        currentSize++;
    }
    public void addLastWithTail(E data){//O(1)
        Node<E> node = new Node<>(data);
        if(head == null){
            head = node;
            tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }


    //Works if i make Node static class
    //---------------------------
//        List.head = new Node(1);//trebuie sa fac un head in lista
//        //pe urma fac un Node sau mai multi si ii link-uiesc intre ei
//        Node second = new Node(2);
//        Node third = new Node(3);
//        Node forth = new Node(4);
    //Acum ii link-uiesc intre ei leg data cu null-ul
//        List.head.next = second;
//        second.next = third;
//        third.next = forth;
    public void addNodeAfterAnExistingNode(E data, Node<E> prevNode) {
        Node<E> node = new Node<>(data);
        if (prevNode.next == null) {
            prevNode.next = node;
            System.out.println("Can't be added between, so it was added As last Element in the LinkedList");
            currentSize++;
            return;
        }
        node.next = prevNode.next;
        prevNode.next = node;
        currentSize++;
    }
    //-----------------------------

    public void addAfterAnElement(E data, int position) {
        Node<E> node = new Node<>(data);
        Node<E> temp = head;
        if (temp == null || temp.next == null) {
            addLast(data);
            return;
        }
//
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        tail= node;
        currentSize++;

    }

    public void removeAfterAnElement(int position) {
        if (head == null) {
            return;
        }
        Node<E> temp = head;
        //if we remove head
        if (position == 0) {
            head = temp.next;
            currentSize--;
            return;
        }
        //obtin previous
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null)
            return;
        //previous next(temp.next) o sa fie jump peste ala sters
        temp.next = temp.next.next;
        currentSize--;
    }

    public E deleteFirst() {
        //daca head-ul e null, nu am ce sa fac, returnez null
        if (head == null) {
            return null;
        }
        E tmp = head.data;
        //daca am un singur element
        //check if has only 1 element ?
        //if(currentSize == 1)
        // if(head.next == null)
        // if(head == tail)
        if (head.next == null) {
            head = null;
        }
        if (head != null)
            head = head.next;
        currentSize--;
        return tmp;
    }

    public E deleteLast() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return deleteFirst();
        }
        Node<E> current = head;
        while(current.next.next != null){
            current = current.next;
        }

        current.next = null;
        tail = current;
        currentSize--;
        return current.data;
    }

    public void printList() {
        Node<E> n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    //Inner class so restricts the acces, no one can modify our next pointer or data values
    //implement Node
    class Node<E> {
        E data;
        Node<E> next;
        E tail;
        public Node(E data) {
            this.data = data;
            next = null;
            tail = null;
        }
    }
}
//nu stiu daca merge pt ca pun noul node inainte de after si dupa prev , in metoda addNodeAfterAnExistingNode() adaug direct dupa si e mai usor
//   public void addNodeBeforeAnExistingNode(E data, Node prevNode ,Node afterNode){
//         Node<E> node = new Node<>(data);
//         if(prevNode.next == null || afterNode == null){
//             prevNode.next = node;
//             currentSize++;
//             return;
//         }
//         node.next = afterNode;
//         prevNode.next = node;
//         currentSize++;
//
//   }