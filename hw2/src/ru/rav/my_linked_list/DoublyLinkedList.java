package ru.rav.my_linked_list;

public class DoublyLinkedList implements DoublyList {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val, null);
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next == null) {
            current.next = new Node(val);
            current.next.previous = current;
            last = current.next;
            return;
        }
        add(current.next, val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                current.next.setPrevious(prev);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public String get(int index) {
        if ((index < size) && (index >= 0)) {
            Node current = first;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return current.val;
                } else current = current.next;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DoublyIterator iterator() {
        return new CustomIterator(first, last);
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "first=" + first +
                '}';
    }

    private static class Node {
        private String val;
        private Node next;
        private Node previous;

        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node previous) {
            this.val = val;
            this.previous = previous;
        }

        public Node(String val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            if (previous == null) {
                return "Node{" +
                        "val='" + val + '\'' +
                        ", previous=null " +
                        ", next=" + next +
                        '}';
            } else {
                return  "Node{" +
                        "val='" + val + '\'' +
                        ", previous=" + previous.val +
                        ", next=" + next +
                        '}';
            }
        }
    }

    public static class CustomIterator implements DoublyIterator {
        private Node current;
        private Node revCurrent;

        public CustomIterator(Node current, Node revCurrent) {
            this.current = current;
            this.revCurrent = revCurrent;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public boolean hasPrevious() {
            return revCurrent != null;
        }

        @Override
        public String previous() {
            String val = revCurrent.val;
            revCurrent = revCurrent.previous;
            return val;
        }
    }
}
