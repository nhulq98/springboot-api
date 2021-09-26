package com.laptrinhjavaweb.test;

import com.laptrinhjavaweb.dto.AbstractDTO;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class StaticNestedClass {
        private String name;
        private static String fullName;
        private String temp;

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public static String getFullName() {
            return fullName;
        }

        public static void setFullName(String fullName) {
            StaticNestedClass.fullName = fullName;
            new StaticNestedClass().temp = fullName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class NoneStaticNestedClass {
    }
}

//
//    private static String staticVariable;
//    private String noneStaticVariable;

//class a{
//    public static void main(String[] args) {
//
//        System.out.println("The memory address is " + VM.current().addressOf(null));
//        System.out.println("The memory address is " + VM.current().addressOf(null));
//    }
//}
