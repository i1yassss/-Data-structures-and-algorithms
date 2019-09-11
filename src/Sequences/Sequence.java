package Sequences;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sequence {

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
        int[] prev = new int[elements.length];

        for(int i = 0; i < elements.length; i++){
            sec[i] = 1;
            prev[i] = -1;
            for (int j = 0; j <= i - 1; j++){
                if((elements[i] % elements[j] == 0) && (sec[j] + 1 > sec[i])){
                    sec[i] = sec[j] + 1;
                    prev[i] = j;

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
