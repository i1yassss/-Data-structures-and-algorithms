package Haffman;
import java.util.*;

public class Haffman {

    class Node implements Comparable<Node>{
        final int sum;
        String code;

        // процедура: какой код нужно присвоить этому узлу
        // выполняется всегда для всех узлов, для внутренних и для листев
        void buildCode(String code){
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }
    //внутрениий узел, у которого есть 2 ребенка, левый и правый
    class InternalNode extends Node{
        Node left;
        Node right;

        //выполняется только для внутренних узлов
        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    // лист хранит символ
    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }


    private void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //если в списке содержится символ
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        /*for (Map.Entry entry : count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue priorityQueue = new PriorityQueue();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            //добавили в очередь все листовые узлы
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        //нужно брать по 2 узла, и склеивать их в один
        while (priorityQueue.size() > 1) {
            Node first = (Node) priorityQueue.poll();
            Node second = (Node) priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        if (count.size() == 1) {
            sum = s.length();
        }
        System.out.println(count.size() + " " + sum);
        Node root = (Node) priorityQueue.poll();
        if (count.size() == 1) {
            root.buildCode("0");
        } else{
            root.buildCode("");
        }
        String encoded = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            encoded += charNodes.get(c).code;
        }
        System.out.println(encoded);

    }

    public static void main(String[] args) {
        new Haffman().run();
    }

}
