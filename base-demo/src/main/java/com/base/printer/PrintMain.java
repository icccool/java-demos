package com.base.printer;

import java.util.ArrayList;
import java.util.List;

public class PrintMain {
    public static void main(String[] args) {
        List<Orders> goods = new ArrayList<Orders>();
        goods.add(new Orders("22", "2", "3", "5", "5", "7", "1", 2.0D));
        SalesTicket stk = new SalesTicket(goods, "源辰信息", "" + 1221554, "3", "38400", "38400", "0");
        YcPrinter p = new YcPrinter(stk);
        p.printer();
    }
}
