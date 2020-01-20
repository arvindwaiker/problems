package io.awklabs.linkedlist;

public class ReverseLinkedList {

    public static Node iterativeReverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node recursiveReverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node reverseHead = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }

    static void printList(Node curr) {
        while(curr != null) {
            System.out.print(curr.element + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Before");
        printList(head);
        head = iterativeReverse(head);
        printList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Before");
        printList(head);
        head = recursiveReverse(head);
        printList(head);
    }
}

class Node {
    int element;
    Node next;

    Node(int element) {
        this.element = element;
    }
}
