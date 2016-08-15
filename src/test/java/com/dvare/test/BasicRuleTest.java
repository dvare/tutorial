package com.dvare.test;

import com.dvare.config.RuleConfiguration;
import com.dvare.rule.BasicRule;
import com.dvare.rules.exceptions.IllegalRuleException;
import com.dvare.rules.ruleengine.DVAREEngine;
import com.dvare.rules.ruleengine.RuleEngine;
import junit.framework.TestCase;
import org.junit.Test;

public class BasicRuleTest extends TestCase {
    @Test
    public void testApp() throws IllegalRuleException {

        RuleConfiguration configuration = new RuleConfiguration();
        DVAREEngine dvareEngine = new DVAREEngine(configuration);
        RuleEngine ruleEngine = new RuleEngine(dvareEngine);

        BasicRule basicRule = new BasicRule();
        basicRule.setAge(25);
        ruleEngine.registerRule(basicRule);
        ruleEngine.fireRules();

    }
}
