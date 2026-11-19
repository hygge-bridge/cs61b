package Disc03;

public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public static void evenOdd(IntList lst) {
        if (lst == null || lst.rest == null) {
            return;
        }
        IntList oddList = lst.rest;
        IntList second = oddList;
        while (lst.rest != null && oddList.rest != null) {
            lst.rest = lst.rest.rest;
            oddList.rest = oddList.rest.rest;
            lst = lst.rest;
            oddList = oddList.rest;
        }
        lst.rest = second;
    }

    public static IntList reverse(IntList L) {
        if (L == null || L.rest == null) {
            return L;
        }
        IntList reversedList = reverse(L.rest);
        L.rest.rest = L;
        L.rest = null;
        return reversedList;
    }
}
