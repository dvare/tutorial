package com.dvare.rule;

import com.dvare.rules.annotations.*;

@Rule(name = "basicRule", priority = 0)
public class BasicRule {

    private Integer age;
    @Condition(type = ConditionType.CODE)
    public boolean condition() {

        return age > 20 && age < 30;
    }

    @Before
    public void beforeAction() {
        System.out.println("Before Rule");
    }

    @Success
    public void success() {
        System.out.println("Rule Successfully Run");
    }

    @Fail
    public void fail() {
        System.out.println("Rule Failed");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
