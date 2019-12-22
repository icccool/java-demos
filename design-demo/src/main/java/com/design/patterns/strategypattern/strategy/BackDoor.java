package com.design.patterns.strategypattern.strategy;

/**
 * @Author WANG JI BO
 * @Date 2019/10/5 21:43
 * @Description 锦囊之一 ： 找乔国老帮忙，使孙权不能杀刘备
 **/
public class BackDoor implements IStrategy {

    public void operate() {
        System.out.println("找乔国老帮忙，让吴国给孙权施加压力");
    }
}
