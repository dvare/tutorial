package org.dvare.framework;


import org.dvare.framework.test.aggregation.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
     /*   FunctionTestExclude.class,*/
        SumTest.class,
        MinTest.class,
        MaxTest.class,
        FirstTest.class,
        LastTest.class,
        MeanTest.class,
        ModeTest.class,
        MedianTest.class,
        SemicolonTest.class,
        ConditionTest.class,
        LengthTest.class,
        ConditionChainTest.class,
        ValuesTest.class,
        DistanceTest.class})
public class AggregationTest {

}
