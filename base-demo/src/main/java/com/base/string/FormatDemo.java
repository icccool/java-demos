package com.base.string;

public class FormatDemo {

    public static void main(String[] args) {
        System.out.println(String.format("%10s","的"));
        System.out.println(String.format("%10s","的"));
        String dateStr = "2022-02-21 20:18:23";
        System.out.println(dateStr.substring(0,7).replace("-",""));
    }

}
