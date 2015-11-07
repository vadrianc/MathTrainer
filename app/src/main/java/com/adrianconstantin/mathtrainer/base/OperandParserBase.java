package com.adrianconstantin.mathtrainer.base;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public abstract class OperandParserBase<T extends Number> implements IOperandParser {
    /**
     *
     */
    protected T mFirstOperand;

    /**
     *
     */
    protected T mSecondOperand;

    /**
     *
     * @param firstOperand
     * @param secondOperand
     */
    public OperandParserBase(IOperationHandler handler){
        mFirstOperand = (T)handler.GetFirstOperand();
        mSecondOperand = (T)handler.GetSecondOperand();
    }

    /**
     *
     * @return
     */
    public abstract String GetFirstOperandString();

    /**
     *
     * @return
     */
    public abstract String GetSecondOperandString();
}
