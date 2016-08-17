package com.dvare.test;


import com.dvare.binding.rule.Rule;
import com.dvare.config.RuleConfiguration;
import com.dvare.evaluator.RuleEvaluator;
import com.dvare.exceptions.interpreter.InterpretException;
import com.dvare.exceptions.parser.ExpressionParseException;
import com.dvare.expression.Expression;
import com.dvare.util.EqualOperation;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DvareRuleTest extends TestCase {
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    public void testApp() throws ExpressionParseException, InterpretException, ParseException {
        RuleConfiguration factory = new RuleConfiguration(new String[]{"com.dvare.function"});

        String exp = "Variable2 = (1 + 2) " +
                " And Variable0 <= fun( testFunction , 10 ) " +
                " And Variable1 in ['A','B'] " +
                " And Variable2 between [2,4]" +
                " And Variable3 > 3.0 " +
                " And Variable4 = false " +
                " And Variable5 in [12-05-2016,13-05-2016] " +
                " And Variable6 in [12-05-2016-15:30:00,13-05-2016-15:30:00] " +
                " And Variable7 in [R'B1.*',R'A1.*'] ";

        Expression expression = factory.getParser().fromString(exp, EqualOperation.class);
        Rule rule = new com.dvare.binding.rule.Rule(expression);

        EqualOperation equalOperation = new EqualOperation();
        equalOperation.setVariable0(10);
        equalOperation.setVariable1("A");
        equalOperation.setVariable2(3);
        equalOperation.setVariable3(3.2f);
        equalOperation.setVariable4(false);
        equalOperation.setVariable5(dateFormat.parse("12-05-2016"));
        equalOperation.setVariable6(dateTimeFormat.parse("12-05-2016-15:30:00"));
        equalOperation.setVariable7("A1B2");

        RuleEvaluator evaluator = factory.getEvaluator();
        boolean result = evaluator.evaluate(rule, equalOperation);
        assertTrue(result);
    }
}



