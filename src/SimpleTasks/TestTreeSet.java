package SimpleTasks;

import java.util.TreeSet;

class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Item> set = new TreeSet<Item>();
        set.add(new Item(2));
        set.add(new Item(5));
        set.add(new Item(2));
        System.out.println(set);
    }


    static class Item implements Comparable<Item>{
        public int getN() {
            return n;
        }

        int n;

        Item(int n) {
            this.n = n;
        }

        public String toString() {
            return "Item " + n;
        }

        @Override
        public int compareTo(Item o) {
            return n - (o.getN());
        }
    }
}
