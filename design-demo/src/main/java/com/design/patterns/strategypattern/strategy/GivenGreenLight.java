package com.design.patterns.strategypattern.strategy;

/**
 * @Author WANG JI BO
 * @Date 2019/10/5 22:12
 * @Description 锦囊之一 ： 求吴太国开绿灯
 **/
public class GivenGreenLight implements IStrategy {

    @Override
    public void operate() {
        System.out.println("求吴国开个绿灯,放行！");
    }

}
