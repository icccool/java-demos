package com.base.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 * @Author WANG JI BO
 * @Date 2019/12/3 9:23 PM
 * @Description
 **/
public class EvalScriptText {
    public static void main(String[] args) {
        evalScriptText();
    }

    /**
     * 简答脚本执行
     *
     * @throws Exception
     */
    public static void evalScriptText() {
        StringBuffer buffer = new StringBuffer();
        //define API
        buffer.append("class User{")
                .append("String name;Integer age;")
                //.append("User(String name,Integer age){this.name = name;this.age = age};")
                .append("String sayHello(){return 'Hello,I am ' + name + ',age ' + age;}}\n");
        //Usage
        buffer.append("def user = new User(name:'zhangsan',age:1);")
                .append("user.sayHello();");
        //groovy.lang.Binding
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        String message = (String)shell.evaluate(buffer.toString());
        System.out.println(message);
        //重写main方法,默认执行
        String mainMethod = "static void main(String[] args){def user = new User(name:'lisi',age:12);print(user.sayHello());}";
        shell.evaluate(mainMethod);
        shell = null;
    }
}
