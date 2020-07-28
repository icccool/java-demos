package com.base.list;

import com.base.util.NumberUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListIteratorTest {

    public static boolean divExactly(Object inputNum) {
        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal(String.valueOf(inputNum));
        if (!Objects.equals(b2, BigDecimal.ZERO)) {
            // 指定计算结果的精度，保留到小数点后几位，以及舍入模式
            BigDecimal b3 = b1.divide(b2, 5, BigDecimal.ROUND_HALF_UP);
            BigDecimal b4 = b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP);
            return (b3.compareTo(b4) == 0);
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(NumberUtil.div(1,3));

        System.out.println(divExactly(3));
        System.out.println(divExactly(2));
        System.out.println(divExactly(40));
        System.out.println(divExactly(70));
//
//        List<String> listStrs = new ArrayList<>();
//        listStrs.add("aaa");
//        listStrs.add("bbb");
//        Iterator it = listStrs.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//            if(!it.hasNext()){
//                System.out.println("没有了");
//            }
//        }
    }
}
