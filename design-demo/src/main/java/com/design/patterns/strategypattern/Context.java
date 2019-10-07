package com.design.patterns.strategypattern;

import com.design.patterns.strategypattern.strategy.IStrategy;

/**
 * @Author WANG JI BO
 * @Date 2019/10/5 21:40
 * @Description 锦囊
 **/
public class Context {

    private IStrategy iStrategy;

    public Context(IStrategy iStrategy){
        this.iStrategy = iStrategy;
    }

    public  void operate(){
        this.iStrategy.operate();
    }

}
