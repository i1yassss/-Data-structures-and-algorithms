package QuickSort;

import java.util.Comparator;

public class CompareRight implements Comparator<Segments>{
    @Override
    public int compare(Segments o1, Segments o2) {
        return o1.getB() - o2.getB();
    }

}
