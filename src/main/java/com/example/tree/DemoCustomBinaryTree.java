package com.example.tree;

import java.util.Comparator;

public class DemoCustomBinaryTree {

    public static void main(String[] args) {


        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

        Comparator<Integer> comparator1 = (o1, o2) -> o1 - o2;

        Comparator<Integer> comparator2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };




        CustomBinaryTree<Integer> binaryTree = new CustomBinaryTree<>(comparator);

        binaryTree.put(5);
        binaryTree.put(4);
        binaryTree.put(4);
        binaryTree.put(3);
        binaryTree.put(2);
        binaryTree.put(7);
        binaryTree.put(8);
        binaryTree.put(6);

        System.out.println();


    }



}
