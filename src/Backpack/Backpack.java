package Backpack;

import java.util.*;

public class Backpack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int n = sc.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++){
            mas[i] = sc.nextInt();
        }
        int[][] D = new int[W+1][n+1];

        for (int w = 0; w < W; w++){
            D[w][0] = 0;
        }
        for (int i = 0; i < n; i++){
            D[0][i] = 0;
        }
        for (int i = 1; i <= n; i++){
            for(int w = 1; w <= W; w++){
                D[w][i] = D[w][i-1];
                if(mas[i-1] <= w){
                    D[w][i] = Math.max(D[w][i-1], D[w - mas[i-1]][i-1] + mas[i-1]);
                }
            }
        }
        System.out.println(D[W][n]);


    }
}

