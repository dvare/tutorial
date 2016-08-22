package com.dvare.test.rule;


import com.dvare.annotations.*;
import org.apache.log4j.Logger;

@Rule(name = "basicRule", priority = 0)
public class BasicRule {
    Logger logger = Logger.getLogger(BasicRule.class);
    private Integer age;

    @Condition(type = ConditionType.CODE)
    public boolean condition() {
        return age > 20 && age < 30;
    }

    @Success
    public void success() {
        logger.info("Rule Successfully Run");
    }
    @Fail
    public void fail() {
        logger.error("Rule Failed");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
