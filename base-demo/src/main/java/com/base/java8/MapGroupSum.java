package com.base.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WANG JI BO
 * @Date 2019/12/3 6:49 PM
 * @Description
 **/
public class MapGroupSum {
    public static void main(String[] args) {
        List<WareVo> items = new ArrayList<WareVo>();
        items.add(new WareVo(1L, 5));
        items.add(new WareVo(2L, 3));
        items.add(new WareVo(1L, 3));

    }

    static class WareVo {

        Long wareId;
        Integer wareNum;

        public WareVo(Long wareId, Integer wareNum) {
            this.wareId = wareId;
            this.wareNum = wareNum;
        }

        public Long getWareId() {
            return wareId;
        }

        public void setWareId(Long wareId) {
            this.wareId = wareId;
        }

        public Integer getWareNum() {
            return wareNum;
        }

        public void setWareNum(Integer wareNum) {
            this.wareNum = wareNum;
        }

    }

}
