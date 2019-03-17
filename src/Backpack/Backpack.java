package Backpack;

import java.util.*;

public class Backpack {
    static int weight = 0;
    static double backcost = 0;
    static int _n = 0;
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Weight = sc.nextInt();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        while (_n < n) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int key = a / b;
            treeMap.put(key, a);
            _n++;
        }
        Backpack1(treeMap, n, Weight);


    }
    private static void  Backpack1(Map<Integer, Integer> treeMap, int n, int Weight){
        ArrayList cost = new ArrayList();
        ArrayList cw = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            //стоимость
            cost.add(entry.getValue());
            //стоимость за 1 кг
            cw.add(entry.getKey());
        }
        Collections.reverse(cw);
        Collections.reverse(cost);
        int size = 0;
        for (int i = 0; i < n; i++) {
            int first = (int) cost.get(i);
            int second = (int) cw.get(i);
            int w = first / second;
            System.out.println(w + " " + cost.get(i));
            if(weight < Weight) {
                backcost += (int) cost.get(i);
                cost.remove(i);
                cw.remove(i);
                weight += w;
                size++;
            }
        }
       /* while (weight < Weight){
            for (int i = 0; i < n-size; i++){
                //объем
                //int w = (int) cost.get(i) / (int) cw.get(i);
                int first = (int) cost.get(i);
                int second = (int) cw.get(i);
                int p = Weight - weight;
                if(first < second && first < p){
                    backcost += (int) cw.get(i);
                    weight += 1;
                }
            }
        }*/
        System.out.printf("%.3f", backcost);
    }
}

