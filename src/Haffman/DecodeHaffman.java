package Haffman;

public class DecodeHaffman {
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

}
