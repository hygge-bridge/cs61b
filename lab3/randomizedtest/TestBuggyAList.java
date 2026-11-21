package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aList = new AListNoResizing<>();
        BuggyAList<Integer> bList = new BuggyAList<>();
        int[] nums = new int[]{4, 5, 6};
        for (int num : nums) {
            aList.addLast(num);
            bList.addLast(num);
        }
        assertAlistEquals(aList, bList);
        for (int i = 0; i < nums.length; i += 1) {
            aList.removeLast();
            bList.removeLast();
            assertAlistEquals(aList, bList);
        }
    }

    private void assertAlistEquals(AListNoResizing<Integer> a, BuggyAList<Integer> b) {
        for (int i = 0; i < a.size(); i += 1) {
            assertEquals(a.get(i), b.get(i));
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                assertEquals(L.getLast(), B.getLast());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bSize = B.size();
                assertEquals(size, bSize);
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    assertEquals(L.getLast(), B.getLast());
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    assertEquals(L.removeLast(), B.removeLast());
                }
            } else if (operationNumber == 4) {
                assertAlistEquals(L, B); // assert get
            }
        }
    }
}
