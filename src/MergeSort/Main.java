package MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static long count = 0;
    private static int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];
        for (int k = 0; k < res.length; k++) {
            if (j == b.length || (i < a.length && a[i] <= b[j])){
                res[k] = a[i];
                i++;
            }else{
                //a[i] > b[j]
                count += a.length - i;
                res[k] = b[j];
                j++;
            }
        }
        return res;
    }
    private static int[] mergeSort(int[] a){

        if(a.length == 1) return a;
        int n = a.length;
        int m = n/2;
        int[] left = new int[m];
        int[] right = new int[n-m];
        System.arraycopy(a, 0, left, 0, m);
        System.arraycopy(a, m, right, 0, n - m);
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] a = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
        int[] sortedA = mergeSort(a);
        System.out.println(count);
        /*for (int i = 0; i < n; i++) {
            System.out.println(sortedA[i]);
        }*/

    }


}
