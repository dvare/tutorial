package com.dvare.rules;

import com.dvare.rule.DvareBaseFileRule;
import com.dvare.rule.DvareBaseRule;
import com.dvare.rules.exceptions.IllegalRuleException;
import com.dvare.rules.ruleengine.RuleEngine;
import junit.framework.TestCase;
import org.junit.Test;

public class DvareBaseFileRuleTest extends TestCase {
    @Test
    public void testApp() throws IllegalRuleException {

        RuleEngine ruleEngine = new RuleEngine();
        DvareBaseFileRule dvareRule = new DvareBaseFileRule();
        dvareRule.setAge(25);
        ruleEngine.registerRule(dvareRule);
        ruleEngine.fireRules();

    }
}
