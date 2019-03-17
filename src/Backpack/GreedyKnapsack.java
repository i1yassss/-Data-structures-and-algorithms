package Backpack;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyKnapsack {

    class Item implements Comparable<Item>{
        int cost;
        int weight;

        public Item(int cost, int weight){
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{"+
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        //компаратор сравнивает два объекта, возвращает -1 если о1 меньше, 1 если о1 больше и 0 если равны
        // тут говорим, что объекты класса item можем сравнивать с другими объектами класса item
        @Override
        public int compareTo(Item o) {
            long r1 = (long) cost * o.weight;
            long r2 = (long) o.cost * weight;

            //в нашем случае сравниваем отношение стоимости к весу
            //double r1 = (double) cost / weight;
            //double r2 = (double) o.cost / o.weight;
            // если поставить "-", компаратор вернет обратное значение
            return -Double.compare(r1, r2);
        }
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int W = input.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++){
            items[i] = new Item(input.nextInt(), input.nextInt());
        }
        Arrays.sort(items);
        double result = 0;
        for (Item item : items){
            //если вес предмета меньше вместимости рюкзака
            if (item.weight <= W) {
                //кладем в рюкзак предмет
                result += item.cost;
                W -= item.weight;
            }else{
                //иначе кладем кусочек
                result += item.cost * W / item.weight;
                break;
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        new GreedyKnapsack().run();

    }
}
