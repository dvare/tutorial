package com.dvare.test;

import com.dvare.config.RuleConfiguration;
import com.dvare.exceptions.rule.IllegalRuleException;
import com.dvare.rule.TextualRule;
import com.dvare.ruleengine.RuleEngine;
import com.dvare.ruleengine.TextualRuleEngine;
import com.dvare.util.Person;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class TextualRuleTest extends TestCase {
    @Test
    public void testApp() throws IllegalRuleException {

        RuleConfiguration configuration = new RuleConfiguration();
        TextualRuleEngine textualRuleEngine = new TextualRuleEngine(configuration);
        RuleEngine ruleEngine = new RuleEngine(textualRuleEngine);

        Person male = new Person();
        male.setAge(23);
        male.setGroup("adult");
        male.setGender("Male");
        male.setTitle("Mr");

        TextualRule textualRule = new TextualRule();
        textualRule.setPerson(male);
        textualRule.setRule("age between [ 19 , 25 ] And group = 'adult' And title = 'Mr' And gender = 'Male'");
        URL url = this.getClass().getClassLoader().getResource("rules/age_rule.dvr");
        textualRule.setFileRule(new File(url.getFile()));
        ruleEngine.registerRule(textualRule);


        Person female = new Person();
        female.setAge(30);
        female.setGroup("teenager");
        female.setGender("Female");
        female.setTitle("Ms");

        TextualRule textualRule2 = new TextualRule();
        textualRule2.setPerson(female);
        textualRule2.setRule("age between [ 10 , 18 ] And group = 'teenager' And title = 'Ms' And gender = 'Female'");
        URL url2 = this.getClass().getClassLoader().getResource("rules/age_rule2.dvr");
        textualRule2.setFileRule(new File(url2.getFile()));
        ruleEngine.registerRule(textualRule2);
        ruleEngine.fireRules();

    }
}






