package com.base.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/***
 * map 转list
 */
public class MapToList {
    public static void main(String[] args) {


        LinkedHashMap<String, Integer> map = new LinkedHashMap();
        map.put("aaa", 2);
        map.put("aaa1", 2);
        map.put("aaa2", 3);
        map.put("aaa3", 4);
        map.put("aaa4", 5);
        map.put("aaa5", 6);
        System.out.printf(new ArrayList<Integer>(map.values()).toString());
    }

}
