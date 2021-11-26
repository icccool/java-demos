package com.base;

/**
 * @Author WANG JI BO
 * @Date 2019/9/5 下午3:48
 * @Description
 **/
public class Test {
    public static void main(String[] args) {
        Integer i1  = new Integer(126);
        Integer i2  = new Integer(126);
        System.out.println(i1.equals(i2)); //ture
        System.out.println(i1 == (i2)); //false
        System.out.println("--------------------");
        Integer i11  = 128;
        Integer i22  = 128;
        System.out.println(i11.equals(i22)); //ture
        System.out.println(i11 == (i22)); //false


    }
}
