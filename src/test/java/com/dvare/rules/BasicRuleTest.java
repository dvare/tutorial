package com.dvare.rules;

import com.dvare.rule.BasicRule;
import com.dvare.rules.exceptions.IllegalRuleException;
import com.dvare.rules.ruleengine.RuleEngine;
import junit.framework.TestCase;
import org.junit.Test;

public class BasicRuleTest extends TestCase {
    @Test
    public void testApp() throws IllegalRuleException {

        RuleEngine ruleEngine = new RuleEngine();
        BasicRule basicRule = new BasicRule();
        basicRule.setAge(25);
        ruleEngine.registerRule(basicRule);
        ruleEngine.fireRules();

    }
}
