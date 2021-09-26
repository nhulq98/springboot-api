package com.laptrinhjavaweb.test;

//public class Person {
//    private Student student;
//
//    public void getName(Student student){
//        System.out.println("this is student" + student.getName());
//    }
//
//    public void getName(CongNhan congNhan){
//        System.out.println("this is student" + congNhan.getName());
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//}
//
//class program1{
//    // cách mày khi muốn lấy tên của công nhân thì ta phải viết 1 hàm mới tham số truyền vào là đối tượng công nhân, rồi hàng trăm đói tượng khác thì sao
//    public static void main(String[] args) {
//        Person person = new Person();
//        person.getName(new Student());
//    }
//}

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.exception.DivideByZeroException;

import javax.validation.constraints.Null;
import java.lang.reflect.Field;

public class Person{
    static String name;

    public static int divideForZero(int b) throws DivideByZeroException
            {
        if(b == 0){
            //throw new NullPointerException("le quang nhu");
            System.out.println(2/b);
        }else{
            System.out.println(2/b);
            System.out.println("no Exception");
        }
        return 2;
    }

    public static void main(String[] args) {
        try{
            divideForZero(0);
        }catch (RuntimeException e){
            System.out.println("catching error success!!");
        }

//    try{
//
//
//    }catch (Exception e){
//        e.printStackTrace();
//        System.out.println(e.getMessage());
//        System.out.println("did error!!");
//    }

//        Field[] fields = BuildingDTO.class.getDeclaredFields();
//        for(Field item: fields){
//            System.out.println(item.toString());
//            if(item.getType().getName().equals("java.lang.String")){
//                System.out.println(item.getName());
//            }
////            if(item.getGenericType()){
////                System.out.println(item.getName());
////            }
//        }
//        String str1 = "";
//        String str2 = new String();
//        System.out.println(str2);
//        Character ch = new Character('a');
//        Character ch2 = new Character('a');
//
//        System.out.println(ch == ch2 ? "bang nhau" : "khac nhau");
//
//        System.out.println(str1 == str2 ? "bang nhau" : "khac nhau");

/*//        Main main = new Main();
        //Main.NoneStaticNestedClass staticNestedClass = main. new NoneStaticNestedClass();

        Main.StaticNestedClass nestedClass1 = new Main.StaticNestedClass();
        Main.StaticNestedClass nestedClass2 = new Main.StaticNestedClass();

        nestedClass1.setName("nhu");
        System.out.println(nestedClass1.getName());
        System.out.println(nestedClass2.getName());

        Main.StaticNestedClass.setFullName("le quang nhu");
        System.out.println(nestedClass1.getTemp());
        System.out.println(nestedClass2.getTemp());*/
    }
}
