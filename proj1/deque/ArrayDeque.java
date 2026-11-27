package deque;

import java.util.Iterator;

/** nextLast -> ... <- nextFirst. */
public class ArrayDeque<T> implements Iterable<T>, Deque<T>  {

    public ArrayDeque() {
        items = (T[]) new Object[START_LENGTH];
        size = 0;
        nextFirst = START_FIRST;
        nextLast = START_LAST;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int index = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[index] + " ");
            index = (index + 1) % items.length;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (triggerShrink()) {
            resize(items.length / 4);
        }
        int index = (nextFirst + 1) % items.length;
        T item = items[index];
        items[index] = null;
        nextFirst = index;
        size -= 1;
        return item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (triggerShrink()) {
            resize(items.length / 4);
        }
        int index = (nextLast - 1 + items.length) % items.length;
        T item = items[index];
        items[index] = null;
        nextLast = index;
        size -= 1;
        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size || isEmpty()) {
            return null;
        }
        return items[(nextFirst + index + 1) % items.length];
    }

    @Override
    public Iterator<T> iterator() {
        return new ADIterator();
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

    private boolean triggerShrink() {
        return items.length >= SHRINK_TRIGGER && size < items.length / 4;
    }

    private void resize(int capacity) {
        T[] arr = (T[]) new Object[capacity];
        int index = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i += 1) {
            arr[i] = items[index];
            index = (index + 1) % items.length;
        }
        items = arr;
        nextFirst = arr.length - 1;
        nextLast = size;
    }

    private class ADIterator implements Iterator<T> {

        ADIterator() {
            pos = (nextFirst + 1) % items.length;
        }

        @Override
        public boolean hasNext() {
            return pos != nextLast;
        }

        @Override
        public T next() {
            T item = items[pos];
            pos = (pos + 1) % items.length;
            return item;
        }

        private int pos;
    }

    private static final int START_LENGTH = 8;
    private static final int START_FIRST = START_LENGTH - 1;
    private static final int START_LAST = 0;
    private static final int SHRINK_TRIGGER = 16;

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
}
