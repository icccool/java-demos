package com.base.util;

import java.math.BigDecimal;
import java.util.Objects;

public class NumberUtilTest {
    /**
     * 是否能整除
     * 1/3 = false;
     * 1/4 = true;
     *
     * @param inputNum
     * @return
     */
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

    /**
     * 获得小数部分
     *
     * @param inputNum
     * @return
     */
    public static double getDecimal(double inputNum) {
        int fInt = (int) inputNum;
        BigDecimal b1 = new BigDecimal(Double.toString(inputNum));
        BigDecimal b2 = new BigDecimal(Integer.toString(fInt));
        double fPoint = b1.subtract(b2).setScale(4).doubleValue();
        System.out.println("整数部分为:" + fInt + "\n" + "小数部分为: " + Double.toString(fPoint));
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(getDecimal(1.0001));

        System.out.println(NumberUtil.div(1, 3));
        System.out.println(divExactly(3));
        System.out.println(divExactly(2));
        System.out.println(divExactly(40));
        System.out.println(divExactly(70));
    }


}
