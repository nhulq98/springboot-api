package com.laptrinhjavaweb.test;

public class CongNhan{

    public static void main(String[] args) {
        String[] buildingTypes = {"le quang ", "heheh"};
        String typesSQL = String.join(" or ", buildingTypes);
        System.out.println(typesSQL);
    }

    public void main(){

    }
}
