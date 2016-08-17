package com.dvare.test;

import com.dvare.config.RuleConfiguration;
import com.dvare.exceptions.rule.IllegalRuleException;
import com.dvare.rule.BasicRule;

import com.dvare.ruleengine.RuleEngine;
import com.dvare.ruleengine.TextualRuleEngine;
import junit.framework.TestCase;
import org.junit.Test;

public class BasicRuleTest extends TestCase {
    @Test
    public void testApp() throws IllegalRuleException {

        RuleConfiguration configuration = new RuleConfiguration();
        TextualRuleEngine textualRuleEngine = new TextualRuleEngine(configuration);
        RuleEngine ruleEngine = new RuleEngine(textualRuleEngine);

        BasicRule basicRule = new BasicRule();
        basicRule.setAge(25);
        ruleEngine.registerRule(basicRule);
        ruleEngine.fireRules();
    }
}
