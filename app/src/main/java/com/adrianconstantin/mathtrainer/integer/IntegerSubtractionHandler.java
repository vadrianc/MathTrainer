package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.natural.NaturalOperandParser;
import com.adrianconstantin.mathtrainer.natural.NaturalSubtractionHanlder;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class IntegerSubtractionHandler extends NaturalSubtractionHanlder {
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
