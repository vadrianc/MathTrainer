package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.natural.NaturalDivisionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalOperandParser;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class IntegerDivisionHandler extends NaturalDivisionHandler {
    /**
     *
     */
    @Override
    public void GenerateOperands(){
        CreateRandomOperands();
        SignGenerator.ApplySignsToIntegers(this);
        mOperandParser = new NaturalOperandParser(this);
    }
}
