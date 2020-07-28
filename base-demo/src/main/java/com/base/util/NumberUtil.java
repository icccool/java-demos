package com.base.util;

import java.math.BigDecimal;

public class NumberUtil {
    public static final int DEF_DIV_SCALE = 10;
    public static final int ZERO = 0;
    public static final String ZERO_STR = "0";
    public static final int PRICE_SCALE = 2;
    public static final int AMOUNT_SCALE = 2;

    public NumberUtil() {
    }

    public static String toStockStr(Object v) {
        return toStockStr(v, 4);
    }

    public static String toStockStr(Object v, int scale) {
        if (v == null) {
            return "0";
        } else {
            String valStr = String.valueOf(v);
            return compare(valStr, "0") == 0 ? "0" : (new BigDecimal(valStr)).setScale(scale, 4).stripTrailingZeros().toPlainString();
        }
    }

    public static String toAmountStr(Object v) {
        return toPriceStr(v, 2);
    }

    public static String toAmountStr(Object v, int scale) {
        return toPriceStr(v, scale);
    }

    public static String toPriceStr(Object v, int scale) {
        if (v == null) {
            return scale >= 2 ? "0.00" : "0.0";
        } else {
            String valStr = String.valueOf(v);
            if (compare(valStr, "0") == 0) {
                return scale >= 2 ? "0.00" : "0.0";
            } else {
                return (new BigDecimal(valStr)).setScale(scale, 4).toString();
            }
        }
    }

    public static String toPriceStr(Object v) {
        return toPriceStr(v, 2);
    }

    public static double round(Object v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } else {
            BigDecimal b = new BigDecimal(String.valueOf(v));
            return b.setScale(scale, 4).doubleValue();
        }
    }

    public static double add(Object v1, Object v2, int scale) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.add(b2).setScale(scale, 4).doubleValue();
    }

    public static double add(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.add(b2).doubleValue();
    }

    public static double sub(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.subtract(b2).doubleValue();
    }

    public static double sub(Object v1, Object v2, int scale) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.subtract(b2).setScale(scale, 4).doubleValue();
    }

    public static double mul(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.multiply(b2).doubleValue();
    }

    public static double mul(Object v1, Object v2, int scale) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.multiply(b2).setScale(scale, 4).doubleValue();
    }

    public static double div(Object v1, Object v2) {
        return div(v1, v2, 10);
    }

    public static double div(Object v1, Object v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } else {
            BigDecimal b1 = new BigDecimal(String.valueOf(v1));
            BigDecimal b2 = new BigDecimal(String.valueOf(v2));
            return b1.divide(b2, scale, 4).doubleValue();
        }
    }

    public static double div(Object v1, Object v2, int scale, int round) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } else {
            BigDecimal b1 = new BigDecimal(String.valueOf(v1));
            BigDecimal b2 = new BigDecimal(String.valueOf(v2));
            return b1.divide(b2, scale, round).doubleValue();
        }
    }

    public static BigDecimal[] divideAndRemainder(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.divideAndRemainder(b2);
    }

    public static BigDecimal remainder(Object v1, Object v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } else {
            BigDecimal b1 = new BigDecimal(String.valueOf(v1));
            BigDecimal b2 = new BigDecimal(String.valueOf(v2));
            return b1.remainder(b2).setScale(scale, 4);
        }
    }

    public static int compare(Object v1, Object v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.compareTo(b2);
    }
}
