package com.adrianconstantin.mathtrainer.impl;

import com.adrianconstantin.mathtrainer.base.OperationHandlerBase;
import com.adrianconstantin.mathtrainer.base.OperationType;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public class DivisionHandler extends OperationHandlerBase {
    /**
     *
     * @param firstOperand
     * @param secondOperand
     */
    public DivisionHandler(Double firstOperand, Double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.DIVISION;
    }

    /**
     * @return result of the operation.
     */
    @Override
    public double ExecuteOperation() {
        return mFirstOperand / mSecondOperand;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '/';
    }
}
