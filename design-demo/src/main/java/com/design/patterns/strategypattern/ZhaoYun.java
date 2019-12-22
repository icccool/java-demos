package com.design.patterns.strategypattern;

import com.design.patterns.strategypattern.strategy.BackDoor;
import com.design.patterns.strategypattern.strategy.BlockEnemy;
import com.design.patterns.strategypattern.strategy.GivenGreenLight;

/**
 * @Author WANG JI BO
 * @Date 2019/10/5 21:40
 * @Description 赵云根据不同的策略, 执行不同的操作
 * @URL https://www.runoob.com/design-pattern/strategy-pattern.html
 *
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 * 使用场景：
 * 1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 * 2、一个系统需要动态地在几种算法中选择一种。 3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 *
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
