package QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
В первой строке задано два целых числа \( 1 \le n \le 50000 \) и \( 1 \le m \le 50000 \) — количество
отрезков и точек на прямой, соответственно. Следующие \( n \) строк содержат по два целых числа
\( a_i \) и \( b_i \) (\( a_i \le b_i \)) — координаты концов отрезков. Последняя строка содержит \( m \)
целых чисел — координаты точек. Все координаты не превышают \( 10^8 \) по модулю.
Точка считается принадлежащей отрезку, если она находится внутри него или на границе.
Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
 */

public class PointsAndSegments {

    static BufferedReader sc;
    static StringTokenizer tok;

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(sc.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        run();
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    static void run() throws IOException{
        sc = new BufferedReader(new InputStreamReader(System.in));
        int n = scanInt();
        int m = scanInt();
        //CompareLeft compareLeft = new CompareLeft();
        //CompareRight compareRight = new CompareRight();
        List<Segments> segment = new ArrayList<>();
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            segment.add(new Segments(scanInt(), scanInt()));
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanInt();
        }
        //Collections.sort(segment, compareLeft);
        //Collections.sort(segment, compareLeft);
        for (int i = 0; i < m; i++) {
            int k = 0;
            // O(m) * O(n)
            for (Segments segments : segment) {

                if (segments.getA() <= points[i] && segments.getB() >= points[i])
                    k++;

            }
            System.out.print(k + " ");
        }
        System.out.println("");
    }
}
