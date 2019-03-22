package QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Функция подсчета пересечений в итоге получилась очень простая: есть 2 массива отсортированные по
началам и по концам отрезков и координата искомой точки. В "началах" ищем ﻿сколько отрезков $ x $
 имеют координату начала не правее искомой точки, в "концах" ищем сколько отрезков $ y $ закончились
 строго левее искомой точки. Возвращаем ($ x-y $).
 */

public class QuickSort {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = sc.nextInt();
        }

        int[] sortedA = qsort(0, a1.length - 1, a1);

        for (int i = 0; i < n; i++) {
            System.out.println(sortedA[i]);
        }

    }


    // откуда сортируем и докуда
    static int[] qsort(int l, int r, int[] a) {
        if (l >= r) {
            return a;
        }
        int i = l;
        int j = r;
        int middle = i - (i - j) / 2;
        while (i < j) {
            while (i < middle && (a[i] <= a[middle])) {
                i++;
            }
            while (j > middle && (a[j] >= a[middle])) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                if (i == middle) {
                    middle = j;
                } else if (j == middle) {
                    middle = i;
                }
            }
        }
        qsort(l, middle, a);
        qsort(middle + 1, r, a);
        return a;
    }


}
