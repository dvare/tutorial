package com.dvare.rule;

import com.dvare.binding.data.DataRow;
import com.dvare.binding.model.TypeBinding;
import com.dvare.config.RuleConfiguration;
import com.dvare.exceptions.parser.ExpressionParseException;
import com.dvare.rules.annotations.*;
import com.dvare.rules.ruleengine.DVAREEngine;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Rule(name = "dvareRule", priority = 0)
public class DvareBasedRule {

    private Integer age;
    private String rule;
    private File fileRule;

    @Condition(type = ConditionType.CODE)
    public boolean condition(DVAREEngine dvareEngine) {

        TypeBinding typeBinding = new TypeBinding();
        typeBinding.addTypes("age", "IntegerType");

        DataRow dataRow = new DataRow();
        dataRow.addData("age", age);

        boolean result = false;

        try {
            result = dvareEngine.evaluate(rule, typeBinding, dataRow);
        } catch (ExpressionParseException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Condition(type = ConditionType.CODE)
    public boolean condition2(DVAREEngine dvareEngine) {


        TypeBinding typeBinding = new TypeBinding();
        typeBinding.addTypes("age", "IntegerType");

        DataRow dataRow = new DataRow();
        dataRow.addData("age", age);

        boolean result = false;

        try {
            result = dvareEngine.evaluate(fileRule, typeBinding, dataRow);
        } catch (ExpressionParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public File getFileRule() {
        return fileRule;
    }

    public void setFileRule(File fileRule) {
        this.fileRule = fileRule;
    }
}
