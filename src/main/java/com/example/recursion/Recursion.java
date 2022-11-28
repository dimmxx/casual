package com.example.recursion;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Recursion {

    public static void main(String[] args) {

        File file = new File("/Users/Dmytro_Borysov/Documents");

        walkThrough(file);


    }


    private static void walkThrough(File file, int ... tabs) {

        if (tabs.length == 0){
            tabs = new int[1];
            tabs[0] = 1;
        }

        if (file != null) {
            File[] files = file.listFiles();

            Comparator<File> comparator = (o1, o2) -> {
                int d1 = o1.isDirectory() ? 1 : 0;
                int d2 = o2.isDirectory() ? 1 : 0;
                if(d1 != d2) return d2 - d1;
                return o1.getName().compareTo(o2.getName());
            };

            List<File> list = Arrays.stream(files)
                .sorted(comparator)
                .collect(Collectors.toList());

            for (File f : list) {
                if (f.isFile()) {
                    System.out.println(String.format("%1$" + tabs[0] + "s", " ") + "|- " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println(String.format("%1$" + tabs[0] + "s", " ") + "|- " + "[" + f.getName() + "]");
                    tabs[0] = tabs[0] + 3;
                    walkThrough(f, tabs);
                    tabs[0] = tabs[0] - 3;
                }
            }
        }
    }

    private static boolean arrayBinarySearchRecursive(int[] array, int number) {
        if (array.length == 0) {
            return false;
        }
        if (array.length == 1) {
            return array[0] == number;
        }
        int mid = array[array.length / 2];
        if (mid == number) {
            return true;
        }

        int[] temp = null;
        if (mid < number) {
            temp = Arrays.copyOfRange(array, array.length / 2, array.length);
        } else if (mid > number) {
            temp = Arrays.copyOfRange(array, 0, array.length / 2);
        }
        return arrayBinarySearchRecursive(temp, number);
    }

    private static int factorial(int number) {
        System.out.println("Entering method with number = " + number);
        if (number == 0 || number == 1) {
            System.out.println("Returning: " + number);
            return 1;
        } else {
            System.out.println("Returning: " + number + " * factorial(" + number + " - 1)");
            return number * factorial(number - 1);
        }
/*
Stack:       Return
...              1
2 * f(2 -1)  2*1=2
3 * f(3 -1)  3*2=6
4 * f(4 -1)  4*6=24
 */
    }
}

