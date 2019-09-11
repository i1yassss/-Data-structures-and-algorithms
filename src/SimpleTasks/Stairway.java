package SimpleTasks;

import java.util.Scanner;

public class Stairway {
    private static int N;
    private static int[] arr = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        N = n;
        arr = a;
        System.out.println(foo(0,0));

    }

    static int foo(int step, int sum){
        if(step + 1 < N ){
            if(arr[step] >= 0 || arr[step] > arr[step + 1] ){
                return foo(step + 1, sum + arr[step]);
            }
            if(arr[step] < 0 && arr[step+1] < 0){
                return foo(step + 2, sum + Math.max(arr[step], arr[step + 1]));
            }else if(arr[step + 1] >= 0){
                return foo(step + 1, sum + arr[step + 1] );
            }else if(step < N){
                return sum + arr[step];
            }
        }

        return sum;

        /*if(step + 1 < N ){
            if(arr[step] >= 0 || arr[step] > arr[step + 1] ){
                return foo(step + 1, sum + Math.max(arr[step], arr[step + 1]));
            }
            return foo(step + 2, sum + Math.max(arr[step], arr[step + 1]));
        }else if(step < N){
            return sum + arr[step];
        }
        return sum;*/
    }

}
