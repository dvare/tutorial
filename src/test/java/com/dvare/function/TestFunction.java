package com.dvare.function;

import com.dvare.annotations.FunctionMethod;
import com.dvare.annotations.FunctionService;
import com.dvare.expression.datatype.DataType;

@FunctionService
public class TestFunction {
    @FunctionMethod(returnType = DataType.IntegerType, list = false, parameters = {DataType.IntegerType})
    public Integer testFunction(Integer veriable) {
        System.out.println("inside testFunction with argument value: " + veriable);
        return veriable;
    }
}
