package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heap {

    static List<Integer> list = new ArrayList<Integer>();
    static List<Integer> result = new ArrayList<Integer>();

    static class Operation {
        String command;
        int num;

        public Operation(String command, int num) {
            this.command = command;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "command='" + command + '\'' +
                    ", num=" + num +
                    '}';
        }
    }

    public static void main(String[] args) {
        run();
    }

    static void run() {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Operation[] operations = new Operation[n];
        for (int i = 0; i < n; i++) {
            String operation = sc.next();
            if (operation.equals("ExtractMax")) {
                num = 0;
                ExtractMax(list);
            } else {
                num = sc.nextInt();
                //System.out.println(num);
                list.add(num);
                sort(list);
            }
            operations[i] = new Operation(operation, num);
        }
        /*for (int j = 0; j < list.size(); j++) {
            System.out.println("element " + list.get(j));
        }*/

        for (int j = 0; j < result.size(); j++) {
            System.out.println(result.get(j));
        }


        /*for (Operation o : operations) {
            System.out.println(o.command + " " + o.num);
        }*/
    }

    private static List<Integer> sort(List<Integer> l) {
        int i = l.size() - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && l.get(parent) < l.get(i)) {
            //System.out.println(l.get(parent) +" < "+ l.get(i));
            int temp = l.get(i);
            l.set(i, l.get(parent));
            l.set(parent, temp);

            i = parent;
            parent = (i - 1) / 2;
        }
        return l;
    }

    private static void heapify(int i) {
        int leftChild;
        int rightChild;
        int largestChild;
        for (; ; ) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;
            if (leftChild < list.size() && list.get(leftChild) > list.get(largestChild)) {
                largestChild = leftChild;
            }
            if (rightChild < list.size() && list.get(rightChild) > list.get(largestChild)) {
                largestChild = rightChild;
            }
            if (largestChild == i){
                break;
            }
            int temp = list.get(i);
            list.set(i, list.get(largestChild));
            list.set(largestChild, temp);
            i = largestChild;
        }
    }

    private static List<Integer> ExtractMax(List<Integer> l) {
        result.add(l.get(0));
        l.set(0, l.get(l.size() - 1));
        l.remove(l.size() - 1);
        sort(l);
        heapify(0);
        //System.out.println(l);
        return l;
    }
}

