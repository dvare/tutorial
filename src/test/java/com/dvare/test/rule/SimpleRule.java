package com.dvare.test.rule;


import com.dvare.rule.BasicRule;
import org.apache.log4j.Logger;

public class SimpleRule implements BasicRule {
    Logger logger = Logger.getLogger(BasicRule.class);
    private Integer age;

    @Override
    public String getName() {
        return "basicRule";
    }

    @Override
    public boolean condition() {
        return age > 20 && age < 30;
    }

    @Override
    public void success() {
        logger.info("RuleSuccessfully Run");
    }

    @Override
    public void fail() {
        logger.error("Rule Failed");
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
