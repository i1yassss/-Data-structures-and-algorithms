package SimpleTasks;

import java.util.*;

public class UniqueElements {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 2, 3};
        removeDuplicates(arr);
        /*
        Set<Integer> set = new LinkedHashSet<Integer>();
        set.addAll(Arrays.asList(arr));
        System.out.println(set);*/
    }

    public static int[] removeDuplicates(int[] a) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < a.length; i++){
            set.add(a[i]);
        }
        System.out.println(set);
        int[] array = set.stream().mapToInt(Number::intValue).toArray();
        return toInt(set);
    }
    public static int[] toInt(Set<Integer> set) {
        int[] a = new int[set.size()];
        int i = 0;
        for (Integer val : set) a[i++] = val;
        return a;
    }
}
