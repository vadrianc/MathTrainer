package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.OperandParserBase;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class IntegerOperandParser extends OperandParserBase<Integer> {
    public IntegerOperandParser(IOperationHandler handler){
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
