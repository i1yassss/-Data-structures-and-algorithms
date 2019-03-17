package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BinarySearch {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BinarySearch.run();
    }

    static void run() {
        FastScanner fs = new FastScanner();
        int[] input = new int[fs.nextInt()];
        for (int i = 0; i < input.length; i++)
            input[i] = fs.nextInt();
        int[] target = new int[fs.nextInt()];
        for (int i = 0; i < target.length; i++) {
            target[i] = fs.nextInt();
        }
        for (int i = 0; i < target.length; i++) {
            binarySearch(input, target[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static List<Integer> binarySearch(int[] a, int k) {
        int r = a.length - 1;
        int l = 0;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (a[middle] == k) {
                list.add(middle + 1);
                return list;
            }
            if (a[middle] > k) {
                r = middle - 1;
            } else if (a[middle] < k) {
                l = middle + 1;
            }
        }

        list.add(-1);
        return list;
    }
}
