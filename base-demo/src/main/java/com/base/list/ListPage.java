package com.base.list;

import java.util.ArrayList;
import java.util.List;

/****
 * 增加分页demo
 */
public class ListPage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");

        int pageSize = 5;
        int pageCount = (list.size() + pageSize - 1) / pageSize;
        for (int i = 0; i < pageCount; i++) {
            int from = i * pageSize;
            int to = (i + 1) * pageSize >= list.size() ? list.size() : (i + 1) * pageSize;
            System.out.println(list.subList(from, to));
        }
    }
}
