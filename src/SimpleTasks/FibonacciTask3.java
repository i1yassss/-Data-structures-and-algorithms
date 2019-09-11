package SimpleTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FibonacciTask3 {
    public static void main(String[] args)  throws IOException {
        double start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        System.out.println("n % m = " + getFibonacciRest(n, m));
        System.out.println(System.currentTimeMillis() - start);
    }

    static List<Long> pisano(Long n, Long m){
        List<Long> pisano = new ArrayList<>();
        pisano.add((long) 0);

        if (m == 1){
            return pisano;
        }

        pisano.add((long) 1);

        if (n <= 1){
            return pisano;
        }
        for(int i = 2; i < m * 6; i++){
            pisano.add((pisano.get(i - 1) + pisano.get(i - 2)) % m);
            if(pisano.get(i) == 1 && pisano.get(i-1) == 0){
                break;
            }
        }
        return pisano;
    }
    private static long getFibonacciRest(long n, long m){
        List<Long> s = pisano(n, m);
        long period = s.size() - 2;
        int val = (int)(n % period);
        return s.get(val);
    }
}

