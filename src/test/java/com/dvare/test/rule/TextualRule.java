package com.dvare.test.rule;


import com.dvare.annotations.*;
import com.dvare.ruleengine.TextualRuleEngine;
import com.dvare.util.Person;
import org.apache.log4j.Logger;

import java.io.File;

@Rule(name = "textualRule", priority = 0)
public class TextualRule {
    Logger logger = Logger.getLogger(TextualRule.class);
    private String rule;
    private File fileRule;
    private Person person;

    @Condition(type = ConditionType.TEXT, order = 0)
    public boolean condition(TextualRuleEngine textualRuleEngine) {
        logger.info("Inside Condition 1");
        return textualRuleEngine.evaluate(rule, Person.class, person);
    }

    @Condition(type = ConditionType.TEXT, order = 1)
    public boolean condition2(TextualRuleEngine textualRuleEngine) {
        logger.info("Inside Condition 2");
        return textualRuleEngine.evaluate(fileRule, Person.class, person);
    }

    @Before
    public void beforeAction() {
        logger.info("Before Condition");
    }

    @After
    public void afterAction() {
        logger.info("After Condition");
    }

    @Success
    public void success() {
        logger.info("Rule Successfully Run");
    }

    @Fail
    public void fail() {
        logger.error("Rule Failed");
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setFileRule(File fileRule) {
        this.fileRule = fileRule;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
