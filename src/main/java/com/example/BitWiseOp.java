package com.example;

public class BitWiseOp {


        public static void main(String[] args) {

            // ~ (Bitwise NOT)
            int x = 342;
            System.out.println("NOT");
            System.out.println(Integer.toBinaryString(x));
            System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
            System.out.println(Integer.toBinaryString(~x));
            System.out.println();

            // & (Bitwise AND)
            int y = 56;
            System.out.println("AND");
            System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(x & y)).replace(' ', '0'));
            System.out.println();

            // &=
            System.out.println("&=");
            int a = 0;
            int b = 1;
            System.out.println(String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0'));
            a &= b;
            System.out.println(String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'));
            System.out.println();

            // | (Bitwise OR)
            System.out.println("OR");
            System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(x | y)).replace(' ', '0'));
            System.out.println();

            // |=
            System.out.println("|=");
            a = 0;
            b = 1;
            System.out.println(String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0'));
            a |= b;
            System.out.println(String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'));
            System.out.println();

            // ^ (Bitwise XOR)
            x = 560;
            System.out.println("XOR");
            System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));
            System.out.println(String.format("%32s", Integer.toBinaryString(x ^ y)).replace(' ', '0'));
            System.out.println();




        }






}
