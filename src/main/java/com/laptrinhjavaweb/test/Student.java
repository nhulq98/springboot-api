package com.laptrinhjavaweb.test;

public class Student extends Person {
    private int age;

    public static void main(String[] args){
        System.out.println("First line");
        System.out.println("Second line");
        System.out.println("Third line");
        int[] myIntArray = new int[]{1, 2, 3};
        print4thItemInArray(myIntArray);
        System.out.println("Fourth line");
        System.out.println("Fith line");
    }

    private static void print4thItemInArray(int[] arr) {
        System.out.println(arr[3]);
        System.out.println("Fourth element successfully displayed!");
    }
}
