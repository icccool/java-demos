package com.design.patterns.strategypattern;

import com.design.patterns.strategypattern.strategy.BackDoor;
import com.design.patterns.strategypattern.strategy.BlockEnemy;
import com.design.patterns.strategypattern.strategy.GivenGreenLight;

/**
 * @Author WANG JI BO
 * @Date 2019/10/5 21:40
 * @Description
 **/
public class ZhaoYun {

    public static void main(String[] args) {
        Context context;

        //拆了第一个锦囊
        context = new Context(new BackDoor());
        context.operate();

        //拆了第二个锦囊
        context = new Context(new GivenGreenLight());
        context.operate();

        //拆了第三个锦囊
        context = new Context(new BlockEnemy());
        context.operate();
    }
}
