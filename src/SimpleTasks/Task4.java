package SimpleTasks;/*Задание:
        Даны отрезки на прямой. Найти такие точки, которые лежат на всех заданных отрезках.
        Найденное множество должно быть минимальным по размеру.
        Формат входных данных:
        Первая строка - количество отрезков
        Последующие строки - координаты начала и конца отрезка, разделенные пробелом
        Формат выходных данных:
        Первая строка - количество найденных точек
        Вторая строка - найденные точки, разделенные пробелом
Sample Input 1:

3
1 3
2 5
3 6
Sample Output 1:

1
3
        */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] data = new int[n][];
        int k = 0;
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            data[k++] = new int[]{a,b};
        }
        Arrays.sort(data,(o1, o2) -> {
            int v = o1[1] - o2[1];
            return v != 0 ? v : o1[0] - o2[0];
        });
        cover(data, n);

    }
    private static void cover(int[][] arr, int n) {
        int k = 0;
        ArrayList kordinat = new ArrayList();
        for (int i = 0, l = arr.length; i < l ; i++ ) {
            int point = arr[i][1];
            for (int j = i ; j < l && point <= arr[j][1] && point >= arr[j][0] ; j++) {
                i = j;
            }
            kordinat.add(point);
            k += k;

        }

        System.out.println(k + " count");
        for (int i = 0; i < k; i++){
            System.out.println("koordinats " + kordinat.get(i));

        }
    }
}
