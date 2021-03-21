package com.hepexta.interview;

import java.util.HashSet;

/*
* Given a linked list, check if the linked list has loop or not.
* */
public class LoopedLinkedList {

    static Node head;

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }
    }

    private void push(int i) {
        Node newNode = new Node(i);

        newNode.next = head;

        head = newNode;
    }

    private boolean detectLoop(Node node) {
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        while (node.hasNext()) {
            if (!set.add(node.next)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String args[]) {
        LoopedLinkedList llist = new LoopedLinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        System.out.println(llist.detectLoop(head));

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        System.out.println(llist.detectLoop(head));
    }


}
