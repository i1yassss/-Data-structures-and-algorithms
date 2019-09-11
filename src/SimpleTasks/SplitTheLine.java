package SimpleTasks;

import java.util.Scanner;

public class SplitTheLine {

    public static void main(String[] args){
        //System.out.println(countWords("XMM"));
        String[] arr = "hello".split("");
        for(String s : arr){
            System.out.println(s);
        }
    }
   /* public static int countWords(String s) {
        int count = s.split("").length;
        return count;
    }*/


}
