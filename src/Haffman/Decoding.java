package Haffman;


import java.util.*;

public class Decoding {

    class Node  {
        String sym;
        int code;

        public Node(String sym, int code) {
            this.sym = sym;
            this.code = code;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "sym='" + sym + '\'' +
                    ", code=" + code +
                    '}';
        }
    }

    public static void main(String[] args) {
        new Decoding().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.next().replaceAll("\\: ", ""), sc.nextInt());
        }
        String scode = sc.next();
        //Queue<String> queue = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < scode.length(); i++) {
            arrayList.add(String.valueOf(scode.charAt(i)));
        }
        int i = 0;
        StringBuilder result = new StringBuilder();
        //пока список не пустой
        while (arrayList.size() > 0) {
            //проходимся по узлам
            for (Node node : nodes) {
                String code = String.valueOf(node.code);
                int num = code.length();
                StringBuilder element = new StringBuilder();
                //в элемент добавляем столько же симоволов сколько в выбранном коде
                for(int j = 0; j < num; j++){
                    element.append(String.valueOf(arrayList.get(j)));
                }
                //сравниваем
                if(code.equals(element.toString())){
                    result.append(Arrays.toString(node.sym.split("\\:")));
                    for(int j = 0; j < num; j++){
                        arrayList.remove(i);
                    }
                }
            }
        }
        String formattedString = result.toString()
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
        System.out.println(formattedString);
    }
}
