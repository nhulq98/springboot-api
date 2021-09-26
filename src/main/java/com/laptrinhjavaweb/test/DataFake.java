package com.laptrinhjavaweb.test;

import java.time.LocalDate;
import java.util.Random;

public class DataFake {
    static Random random = new Random();

    // input: string
    //output: String changed
    static String[] tenNhu = {"le quang nhu", "thuy an", "le tuan", "quang huu", "le nhu y", "quang phuc"};
    static String[] tenBinh = {"binh", "le teo", "le tuan", "le loi", "le roi", "le lai"};
    static String[] tenHanh = {"nguyen van a", "nguyen van b", "nguyen van c", "nguyen van d", "nguyen van e", "nguyen van f"};

    public static void taoDataForNhu(){
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        for(int i = 0; i < 10; i++){
            String sqlInsert = "INSERT INTO ANH(ten, ngaysinh, tuoi, sodu)" +
                    "VALUES ('"+tenNhu[i]+"', '"+randomBirthDate+"', 23, 2000000);";
        }
    }

    public static void taoDataForBinh(){

        for(int i = 0; i < 10; i++){
            String sqlInsert = "INSERT INTO ANH(ten, ngaysinh, tuoi, sodu)" +
                    "VALUES ('"+tenBinh[i]+"', '20/03/1998', 23, 2000000);";
        }
    }

    public static void taoDataForHanh(){

        for(int i = 0; i < 10; i++){
            String sqlInsert = "INSERT INTO ANH(ten, ngaysinh, tuoi, sodu)" +
                    "VALUES ('"+tenHanh[i]+"', '20/03/1998', 23, 2000000);";
        }
    }


    public static void main(String[] args) {
        taoDataForNhu();
    }
}
