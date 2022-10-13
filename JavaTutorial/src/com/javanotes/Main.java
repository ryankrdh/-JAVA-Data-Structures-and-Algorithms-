package com.javanotes;

import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String message = "Hello Wor  ld   ";
//        System.out.println(message.replace(" ", ""));
//        System.out.println(message.trim());

//        Point point1 = new Point(1, 1);
//        Point point2 = point1;
//        System.out.println(point2);
//        int[] numbers = { 2, 3, 4, 1, 5 };
//        System.out.println(numbers.length);
//        System.out.println(Arrays.toString(numbers));
//
//        String str1 = "anagram";
//        int[] numbers = new int[];
 //        String[] arr1 = {str1};
//        Arrays.sort(arr1);
//        System.out.println(Arrays.toString(arr1));

//        int result = (int)Math.ceil(1.1F);
//        double result = Math.round(Math.random() * 100);
//        int result = (int)(Math.random() * 100);
//        System.out.println(result);
//
//        String[] fruits = {"Apple", "Mango", "Orange"};
//
////        for loop
//        for (int i = 0; i < fruits.length; i++)
//            System.out.println(fruits[i]);
////        for each. forward only, cannot iterate backwards. no access to each item.
//        for (String fruit : fruits)
//            System.out.println(fruit);
        int rows = 3;
        int columns = 4;

        int [][] my2DArray = new int[rows][columns];

        System.out.println(Arrays.deepToString(my2DArray));

    }
}
