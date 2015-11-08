package com.adrianconstantin.mathtrainer.natural;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.OperandParserBase;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class NaturalOperandParser extends OperandParserBase<Integer> {
    public NaturalOperandParser(IOperationHandler handler){
        super(handler);
    }

    /**
     * @return
     */
    @Override
    public String GetFirstOperandString() {
        return mFirstOperand.toString();
    }

    /**
     * @return
     */
    @Override
    public String GetSecondOperandString() {
        return mSecondOperand.toString();
    }
}
