package Disc03;

import static org.junit.Assert.*;
import org.junit.Test;

public class IntListTest {
    @Test
    public void testEvenOdd() {
        // 1. 准备输入数据 0,3,1,4,2,5
        IntList lst = new IntList(0,
                new IntList(3,
                        new IntList(1,
                                new IntList(4,
                                        new IntList(2,
                                                new IntList(5, null))))));

        // 2. 调用待测方法
        IntList.evenOdd(lst);

        // 3. 期望结果：0,1,2,3,4,5
        IntList expected = new IntList(0,
                new IntList(1,
                        new IntList(2,
                                new IntList(3,
                                        new IntList(4,
                                                new IntList(5, null))))));

        // 4. 断言验证
        IntList p = lst;
        IntList e = expected;
        while (p != null && e != null) {
            assertEquals(e.first, p.first);
            p = p.rest;
            e = e.rest;
        }
        assertNull(p);
        assertNull(e);
    }

    @Test
    public void testReverse() {
        // 构造链表：1 -> 2 -> 3 -> 4
        IntList lst = new IntList(1,
                new IntList(2,
                        new IntList(3,
                                new IntList(4, null))));
        IntList res = IntList.reverse(lst);

        // 预期反转后：4 -> 3 -> 2 -> 1
        IntList expected = new IntList(4,
                new IntList(3,
                        new IntList(2,
                                new IntList(1, null))));

        IntList p = res;
        IntList e = expected;
        while (p != null && e != null) {
            assertEquals(e.first, p.first);
            p = p.rest;
            e = e.rest;
        }
        assertNull(p);
        assertNull(e);
    }


}
