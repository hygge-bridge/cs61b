package Disc03;

import static org.junit.Assert.*;
import org.junit.Test;

public class PartitionTest {
    @Test
    public void testPartition() {
        // 输入链表：5,4,3,2,1，k=2
        IntList lst = new IntList(5,
                new IntList(4,
                        new IntList(3,
                                new IntList(2,
                                        new IntList(1, null)))));
        IntList[] result = Partition.partition(lst, 2);

        // 预期：array[0] = 5 -> 3 -> 1; array[1] = 4 -> 2
        IntList exp0 = new IntList(5, new IntList(3, new IntList(1, null)));
        IntList exp1 = new IntList(4, new IntList(2, null));

        // 校验第0条链表
        IntList p = result[0];
        IntList e = exp0;
        while (p != null && e != null) {
            assertEquals(e.first, p.first);
            p = p.rest;
            e = e.rest;
        }
        assertNull(p);
        assertNull(e);

        // 校验第1条链表
        p = result[1];
        e = exp1;
        while (p != null && e != null) {
            assertEquals(e.first, p.first);
            p = p.rest;
            e = e.rest;
        }
        assertNull(p);
        assertNull(e);
    }

}
