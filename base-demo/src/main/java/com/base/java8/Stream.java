package com.base.java8;

import org.codehaus.groovy.util.StringUtil;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        //        blackInfoDTOS.forEach(e -> pageAnchorShowingList
//                .stream()
//                .filter(anchorShowInfo -> e.getUserId() == anchorShowInfo.getAnchorId())
//                .findFirst()
//                .ifPresent(t->{
//                    t.setGroupId(e.getGroupId());
//                    //
//                });

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

        String filter = "7";
        List ls = list.stream().filter(e-> StringUtils.isBlank(filter) || e.equals(filter)).collect(Collectors.toList());
        System.out.println(ls);

    }
}
