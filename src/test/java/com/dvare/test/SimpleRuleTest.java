package com.dvare.test;


import com.dvare.api.RuleEngineBuilder;
import com.dvare.exceptions.rule.IllegalRuleException;
import com.dvare.ruleengine.RuleEngine;
import com.dvare.test.rule.SimpleRule;
import com.dvare.util.PARAM;
import junit.framework.TestCase;
import org.junit.Test;

public class SimpleRuleTest extends TestCase {
    @Test
    public void testApp() throws IllegalRuleException {

        RuleEngineBuilder ruleEngineBuilder = new RuleEngineBuilder();
        ruleEngineBuilder.satisfyCondition(PARAM.ANY).stopOnFail(false);
        RuleEngine ruleEngine = ruleEngineBuilder.build();

        SimpleRule simpleRule = new SimpleRule();
        simpleRule.setAge(25);
        ruleEngine.registerRule(simpleRule);
        ruleEngine.fireRules();
    }
}
