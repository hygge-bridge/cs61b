package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }

    public T max() {
        return max(comp);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxVal = get(0);
        for (T item : this) {
            if (c.compare(maxVal, item) < 0) {
                maxVal = item;
            }
        }
        return maxVal;
    }

    private Comparator<T> comp;
}
