package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.natural.NaturalAdditionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalOperandParser;

/**
 * Created by AdrianConstantin on 11/8/2015.
 */
public class IntegerAdditionHandler extends NaturalAdditionHandler {
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
