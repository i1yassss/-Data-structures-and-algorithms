package Sequences;

import java.util.Scanner;

/**
 * Дано целое число 1≤n≤10^3 и массив A[1…n] натуральных чисел, не превосходящих 2⋅10^9. Выведите максимальное 1≤k≤n, для которого найдётся подпоследовательность
 * 1≤i1<i2<…<ik≤n длины k, в которой каждый элемент делится на предыдущий (формально: для  всех 1≤j<k, A[ij]|A[ij+1]).
 */
public class MaxSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] A = new int[sc.nextInt()];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(getSeqLenght(A));
    }

    public static int getSeqLenght(int[] elements){

        int[] sec = new int[elements.length];


        for(int i = 0; i < elements.length; i++){
            sec[i] = 1;
            for (int j = 0; j <= i - 1; j++){
                if((elements[i] % elements[j] == 0) && (sec[j] + 1 > sec[i])){
                    sec[i] = sec[j] + 1;

                }
            }
        }
        int max = 0;
        for(int i = 0; i < elements.length; i++){
            if(max < sec[i]){
                max = sec[i];
            }
        }
        return max;

    }

}
