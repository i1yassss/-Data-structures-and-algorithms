package SimpleTasks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// неповторяющие слагаемые числа

public class Task4_1_3 {

    static Stack<Integer> kcats = new Stack<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = (int) (-1 + Math.sqrt(1 + 4 * n)) / 2 + 1;
        int[] mas = new int[size];
        int k = 1;
        int sum = 0;
        while (sum < n){
            if (sum + k <= n){
                sum += k;
                //mas[k - 1] = k;
                stack.push(k);
                k++;
            } else {
                //stack.pop();
                int kk = stack.pop();
                stack.push(kk + n - sum);
                if(n % 2 == 0){
                }else{
                    k = k - 1;
                }
                break;
            }
        }
        printStack(stack);
    }

    private static void printStack(Stack<Integer> s) {
        int _k = 0;
        while (!s.isEmpty()){
            kcats.push(s.pop());
            _k += 1;
        }
        System.out.println (_k);
        while (!kcats.isEmpty()){
            System.out.print(kcats.pop() + " ");
        }

    }

}

