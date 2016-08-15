package com.dvare.test;

import com.dvare.config.RuleConfiguration;
import com.dvare.rule.DvareBasedRule;
import com.dvare.rules.exceptions.IllegalRuleException;
import com.dvare.rules.ruleengine.DVAREEngine;
import com.dvare.rules.ruleengine.RuleEngine;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class DvareBasedRuleTest extends TestCase {
    @Test
    public void testApp() throws IllegalRuleException {

        RuleConfiguration configuration = new RuleConfiguration();
        DVAREEngine dvareEngine = new DVAREEngine(configuration);
        RuleEngine ruleEngine = new RuleEngine(dvareEngine);


        DvareBasedRule dvareRule = new DvareBasedRule();
        dvareRule.setAge(25);
        dvareRule.setRule("age > 20 And age < 30");
        URL url = this.getClass().getClassLoader().getResource("rules/age_rule.dvr");
        dvareRule.setFileRule(new File(url.getFile()));
        ruleEngine.registerRule(dvareRule);

        DvareBasedRule dvareRule2 = new DvareBasedRule();
        dvareRule2.setAge(35);
        dvareRule2.setRule("age > 30 And age < 40");
        URL url2 = this.getClass().getClassLoader().getResource("rules/age_rule2.dvr");
        dvareRule2.setFileRule(new File(url2.getFile()));
        ruleEngine.registerRule(dvareRule2);




        ruleEngine.fireRules();

    }
}
