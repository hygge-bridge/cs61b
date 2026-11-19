package Disc03;

public class Partition {
    public static IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = IntList.reverse(lst);
        while (L != null) {
            IntList prevArrayIndex = array[index];
            IntList next = L.rest;
            array[index] = L;
            array[index].rest = prevArrayIndex;
            L = next;
            index = (index + 1) % array.length;
        }
        return array;
    }

}
