package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addGetTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int N = 10000;
        for (int i = 0; i < N; i += 1) {
            int num = StdRandom.uniform(0, 100);
            deque.addFirst(num);
            assertEquals(num, deque.get(0).intValue());
            deque.addLast(num);
            assertEquals(num, deque.get(deque.size() - 1).intValue());
        }
    }

    @Test
    public void removeTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(12);
        deque.addFirst(11);
        deque.addFirst(10);
        deque.addFirst(9);
        deque.addFirst(8);
        deque.addFirst(7);
        deque.addFirst(6);
        deque.addFirst(5);
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        assertEquals(1, deque.removeFirst().intValue());
        assertEquals(2, deque.get(0).intValue());
        assertEquals(12, deque.removeLast().intValue());
        assertEquals(11, deque.get(deque.size() - 1).intValue());
        ArrayDeque<Integer> d2 = new ArrayDeque<>();
        assertNull(d2.removeFirst());
        assertNull(d2.removeLast());
    }

    @Test
    public void iteratorTest() {
        int[] nums = new int[]{1, 2, 3};
        int i = 0;
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        for (int item : d1) {
            assertEquals(nums[i++], item);
        }
        ArrayDeque<Integer> d2 = new ArrayDeque<>();
        Iterator<Integer> it = d2.iterator();
        if (it.hasNext()) {
            fail();
        }
    }

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        ArrayDeque<Integer> d2 = new ArrayDeque<>();
        d2.addLast(1);
        d2.addLast(2);
        d2.addLast(3);
        assertTrue(d1.equals(d2));
        ArrayDeque<Integer> d3 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);
        assertFalse(d1.equals(d3));
    }

    @Test
    public void printTest() {
        ArrayDeque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(1);
        d1.addLast(2);
        d1.addLast(3);;
        d1.printDeque();
    }
}
