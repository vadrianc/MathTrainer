package com.adrianconstantin.mathtrainer.impl;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.OperandCount;
import com.adrianconstantin.mathtrainer.base.OperationHandlerBase;
import com.adrianconstantin.mathtrainer.base.OperationType;

import java.util.List;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public class AdditionHandler extends OperationHandlerBase {
    /**
     *
     * @param firstOperand
     * @param secondOperand
     */
    public AdditionHandler(Double firstOperand, Double secondOperand) {
        super(firstOperand, secondOperand);
    }

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.ADDITION;
    }

    /**
     * @return result of the operation.
     */
    @Override
    public double ExecuteOperation() {
        return mFirstOperand + mSecondOperand;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '+';
    }
}