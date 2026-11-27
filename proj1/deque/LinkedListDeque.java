package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {

    public LinkedListDeque() {
        sentinel = new Node<T>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<T>(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node<T> node = new Node<T>(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    /** Two bugs? no items but print a new line and there is a space after the last item. */
    @Override
    public void printDeque() {
        for (Node<T> p = sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next.item = null;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.prev.item;
        sentinel.prev.item = null;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return getNode(index).item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getNodeRecursive(index, sentinel.next).item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LLDIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Deque)) {
            return false;
        } else if (this == o) {
            return true;
        }
        Deque<T> other = (Deque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    private Node<T> getNode(int index) {
        Node<T> p = sentinel.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p;
    }

    private Node<T> getNodeRecursive(int index, Node<T> p) {
        if (index == 0) {
            return p;
        }
        return getNodeRecursive(index - 1, p.next);
    }

    private class LLDIterator implements Iterator<T> {

        LLDIterator() {
            curr = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return curr != sentinel;
        }

        @Override
        public T next() {
            T item = curr.item;
            curr = curr.next;
            return item;
        }

        private Node<T> curr;
    }

    private static class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;

        Node(T i, Node<T> p, Node<T> n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private final Node<T> sentinel;
    private int size;
}
