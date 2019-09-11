package SimpleTasks;

import java.util.Scanner;
/*Первая строка содержит число \( 1 \le n \le 10^4 \),
вторая — \( n \) натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.*/

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] C = sort(A);
        for (int i = 0; i < n; i++) {
            System.out.print(C[i] + " ");
        }
    }

    public static int[] sort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int element : array){
            if(element < min){
                min = element;
            }
            if(element > max){
                max = element;
            }
        }
        int[] mas = new int[max - min + 1];
        for (int element : array){
            mas[element - min]++;
        }
        int arrayIndex = 0;
        for(int i = 0; i < mas.length; i++){
            for (int j = mas[i]; j > 0; j--){
                array[arrayIndex++] = i + min;
            }
        }
        return array;
    }
}
