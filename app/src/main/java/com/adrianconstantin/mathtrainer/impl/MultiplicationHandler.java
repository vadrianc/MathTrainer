package com.adrianconstantin.mathtrainer.impl;

import com.adrianconstantin.mathtrainer.base.OperationHandlerBase;
import com.adrianconstantin.mathtrainer.base.OperationType;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public class MultiplicationHandler extends OperationHandlerBase {
    /**
     *
     * @param firstOperand
     * @param secondOperand
     */
    public MultiplicationHandler(Double firstOperand, Double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.MULTIPLICATION;
    }

    /**
     * @return result of the operation.
     */
    @Override
    public double ExecuteOperation() {
        return mFirstOperand * mSecondOperand;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '*';
    }
}
