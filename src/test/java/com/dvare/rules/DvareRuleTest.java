package com.dvare.rules;

import com.dvare.binding.data.DataRow;
import com.dvare.binding.model.TypeBinding;
import com.dvare.binding.rule.Rule;
import com.dvare.binding.validation.ValidationRuleResult;
import com.dvare.config.RuleConfiguration;
import com.dvare.evaluator.RuleEvaluator;
import com.dvare.exceptions.parser.ExpressionParseException;
import com.dvare.expression.Expression;
import junit.framework.TestCase;
import org.junit.Test;

public class DvareRuleTest extends TestCase {

    @Test
    public void testApp() throws ExpressionParseException {
        RuleConfiguration factory = new RuleConfiguration(new String[]{"com.dvare.function"});

        TypeBinding typeBinding = new TypeBinding();
        typeBinding.addTypes("Variable0", "IntegerType");
        typeBinding.addTypes("Variable1", "StringType");
        typeBinding.addTypes("Variable2", "IntegerType");
        typeBinding.addTypes("Variable3", "FloatType");
        typeBinding.addTypes("Variable4", "BooleanType");
        typeBinding.addTypes("Variable5", "DateType");
        typeBinding.addTypes("Variable6", "DateTimeType");
        typeBinding.addTypes("Variable7", "RegexType");

        String exp = "Variable2 = (1 + 2) " +
                " And Variable0 <= fun( testFunction , 10 ) " +
                " And Variable1 in ['A','B'] " +
                " And Variable2 between [2,4]" +
                " And Variable3 > 3.0 " +
                " And Variable4 = false " +
                " And Variable5 in [12-05-2016,13-05-2016] " +
                " And Variable6 in [12-05-2016-15:30:00,13-05-2016-15:30:00] " +
                " And Variable7 in [R'B1.*',R'A1.*'] ";

        Expression expression = factory.getParser().fromString(exp, typeBinding);
        Rule rule = new com.dvare.binding.rule.Rule(expression);

        DataRow dataRow = new DataRow();
        dataRow.addData("Variable0", 10);
        dataRow.addData("Variable1", "'A'");
        dataRow.addData("Variable2", 3);
        dataRow.addData("Variable3", 3.2);
        dataRow.addData("Variable4", false);
        dataRow.addData("Variable5", "12-05-2016");
        dataRow.addData("Variable6", "12-05-2016-15:30:00");
        dataRow.addData("Variable7", "'A1B2'");

        RuleEvaluator evaluator = factory.getEvaluator();
        ValidationRuleResult ruleResult = evaluator.evaluate(rule, dataRow);

        boolean result = ruleResult.isError();

        assertFalse(result);

    }


}



