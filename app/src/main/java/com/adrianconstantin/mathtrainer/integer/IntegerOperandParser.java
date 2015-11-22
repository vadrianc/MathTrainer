package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalOperandParser;

/**
 * Created by AdrianConstantin on 11/22/2015.
 */
public class IntegerOperandParser extends NaturalOperandParser {
    public IntegerOperandParser(IOperationHandler handler) {
        super(handler);
    }

    /**
     * @return
     */
    @Override
    public String GetFirstOperandString() {
        String result = mFirstOperand.toString();

        if (result.startsWith("-")){
            result = String.format("(%s)", result);
        }

        return result;
    }

    /**
     * @return
     */
    @Override
    public String GetSecondOperandString() {
        String result = mSecondOperand.toString();

        if (result.startsWith("-")){
            result = String.format("(%s)", result);
        }

        return result;
    }
}
