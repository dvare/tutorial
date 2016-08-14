package com.dvare.rule;

import com.dvare.binding.data.DataRow;
import com.dvare.binding.model.TypeBinding;
import com.dvare.config.RuleConfiguration;
import com.dvare.exceptions.parser.ExpressionParseException;
import com.dvare.rules.annotations.*;
import com.dvare.rules.ruleengine.TextRuleEngine;

@Rule(name = "dvareRule", priority = 0)
public class DvareBaseRule {


    private Integer age;

    @Condition
    public boolean condition() {
        RuleConfiguration configuration = new RuleConfiguration();
        TextRuleEngine textRuleEngine = new TextRuleEngine(configuration);

        TypeBinding typeBinding = new TypeBinding();
        typeBinding.addTypes("age", "IntegerType");

        DataRow dataRow = new DataRow();
        dataRow.addData("age", age);

        boolean result = false;

        String rule = "age > 20 And age < 30";

        try {
            result = textRuleEngine.evaluate(rule, typeBinding, dataRow);
        } catch (ExpressionParseException e) {
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
}
