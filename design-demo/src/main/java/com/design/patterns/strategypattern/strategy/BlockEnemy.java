package com.design.patterns.strategypattern.strategy;

/**
 * @Author WANG JI BO
 * @Date 2019/10/5 22:24
 * @Description 锦囊之一 ： 孙人断后，挡住追兵
 **/
public class BlockEnemy implements IStrategy{

    public void operate() {
        System.out.println("孙人断后，挡住追兵");
    }
}
