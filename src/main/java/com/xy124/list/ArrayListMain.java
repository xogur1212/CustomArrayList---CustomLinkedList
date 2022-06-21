package com.xy124.list;

import com.xy124.list.CustomArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {

        CustomArrayList customArrayList = new CustomArrayList(2);
        List<Integer> integerArrayList = new ArrayList<>();
        customArrayList.add(50);
        customArrayList.add(50);



        System.out.println("=========== start ==========");
        for (int data : customArrayList.getData()) {

            System.out.println(data);



        }
        System.out.println("=========== end ==========");
        customArrayList.add(50);



        System.out.println("=========== start ==========");

        for (int data : customArrayList.getData()) {
            System.out.println(data);

        }
        System.out.println("=========== end ==========");

        customArrayList.remove();
        System.out.println("=========== start ==========");

        for (int data : customArrayList.getData()) {
            System.out.println(data);

        }
        System.out.println("=========== end ==========");


    }
}