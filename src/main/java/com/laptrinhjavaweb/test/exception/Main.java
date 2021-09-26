package com.laptrinhjavaweb.test.exception;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private int age;


    public static void main(String[] args){
        System.out.println("First line");
        System.out.println("Second line");
        System.out.println("Third line");

        //getName();

        System.out.println("Fourth line");
        System.out.println("Fith line");
    }

    private static void print4thItemInArray(int[] arr) {
        System.out.println(arr[3]);
        System.out.println("Fourth element successfully displayed!");
    }
}
