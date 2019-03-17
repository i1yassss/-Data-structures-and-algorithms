package SimpleTasks;

import java.util.Scanner;

public class Nod {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        long a = (long) sc.nextLong();
        long b = (long) sc.nextLong();
        rec(a, b);
    }

    static Long rec(long a, long b) {
        if (a == 0) {
            System.out.print(b);
            return b;
        } else if (b == 0) {
            System.out.print(a);
            return a;
        } else if (a >= b) {
            return  rec(a % b, b);
        } else if (b >= a) {
            return  rec(a, b % a);
        }
        return null;
    }
}
