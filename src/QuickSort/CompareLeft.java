package QuickSort;

import java.util.Comparator;

public class CompareLeft implements Comparator<Segments> {
    @Override
    public int compare(Segments o1, Segments o2) {
        return o1.getA() - o2.getA();
    }
}
