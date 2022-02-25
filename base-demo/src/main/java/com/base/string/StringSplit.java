package com.base.string;

import java.util.Arrays;

public class StringSplit {

    public static void main(String[] args) {
        String str = "1234";
        System.out.println(Arrays.asList(str.split(",")));//这里只会输出一个
    }
}
