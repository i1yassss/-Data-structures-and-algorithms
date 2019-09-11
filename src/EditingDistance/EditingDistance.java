package EditingDistance;

import java.util.Scanner;

public class EditingDistance {

    private String first;
    private String second;

    int[][] d;
    boolean[][] calculated;

    private int editingDistance(int n, int m){
        if (m == 0 && n == 0) return 0;
        if (m == 0) return n;
        if (n == 0) return m;
        if(calculated[n][m]){
            return d[n][m];
        }

        //Действия:
        //если вставка
        int res1 = editingDistance(n, m - 1) + 1;
        //delete
        int res2 = editingDistance(n - 1, m) + 1;
        //замена, если буквы разные прибавит 1, если обинаковые  0
        int res3 = editingDistance(n - 1, m - 1) + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);
        int result = Math.min(Math.min(res1, res2), res3);
        calculated[n][m] = true;
        d[n][m] = result;
        return result;
    }

    private void run(){
        Scanner sc = new Scanner(System.in);
        first = sc.nextLine();
        second = sc.nextLine();
        d = new int[first.length() + 1][second.length() + 1];
        calculated = new boolean[first.length() + 1][second.length() + 1];
        System.out.println(editingDistance(first.length(), second.length()));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new EditingDistance().run();
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}
