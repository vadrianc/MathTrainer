package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.natural.NaturalMultiplicationHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalOperandParser;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class IntegerMultiplicationHandler extends NaturalMultiplicationHandler {
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
