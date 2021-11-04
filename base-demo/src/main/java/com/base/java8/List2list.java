package com.base.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 一个list转为另一个list
 */
public class List2list {
    public static void main(String[] args) {
        List<BillDetail> list = new ArrayList();
        list.add(new BillDetail(1,"AA"));
        list.add(new BillDetail(1,"BB"));
        List<StockC> res= list.stream().map((e)->{
            return new StockC(e);
        }).collect(Collectors.toList());
        System.out.println(res);
    }


    void transform(){
//        Map<String,String> map = new HashMap<>();
//        map.put("1","test1");
//        map.put("2","test2");
//        Map<String,String> map2 = new HashMap<>();
//        map2.put("1","test3");
//        map2.put("4","test2");
//        List<Map<String,String>> list2= new ArrayList<>();
//        list2.add(map);
//        list2.add(map2);
//        List<String> list3=Lists.transform(list2,s->s.get("1"));
//        list3.forEach(s -> System.out.println(s));
    }

    static class  BillDetail{
        int wareCode;

        String madeNumber;

        public BillDetail() {
        }

        public BillDetail(int wareCode, String madeNumber) {
            this.wareCode = wareCode;
            this.madeNumber = madeNumber;
        }

        public int getWareCode() {
            return wareCode;
        }

        public void setWareCode(int wareCode) {
            this.wareCode = wareCode;
        }

        public String getMadeNumber() {
            return madeNumber;
        }

        public void setMadeNumber(String madeNumber) {
            this.madeNumber = madeNumber;
        }
    }
    static  class  StockC{
        int wareCode;

        String madeNumber;

        public StockC(BillDetail b) {
            this.madeNumber = b.getMadeNumber();
        }

        public StockC(int wareCode, String madeNumber) {
            this.wareCode = wareCode;
            this.madeNumber = madeNumber;
        }

        public int getWareCode() {
            return wareCode;
        }

        public void setWareCode(int wareCode) {
            this.wareCode = wareCode;
        }

        public String getMadeNumber() {
            return madeNumber;
        }

        public void setMadeNumber(String madeNumber) {
            this.madeNumber = madeNumber;
        }

        @Override
        public String toString() {
            return "StockC{" +
                    "wareCode=" + wareCode +
                    ", madeNumber='" + madeNumber + '\'' +
                    '}';
        }
    }
}
