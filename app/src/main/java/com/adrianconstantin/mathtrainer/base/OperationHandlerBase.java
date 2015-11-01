package com.adrianconstantin.mathtrainer.base;

import java.util.List;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public abstract class OperationHandlerBase implements IOperationHandler {
    /**
     * First operand.
     */
    protected Double mFirstOperand;

    /**
     * Second operand.
     */
    protected Double mSecondOperand;

    /**
     *
     */
    protected int mOperandCount;

    /**
     *
     */
    public OperationHandlerBase(Double firstOperand)
    {
        mFirstOperand = firstOperand;

        mOperandCount = OperandCount.ONE_OPERAND.GetCount();
    }

    /**
     *
     */
    public OperationHandlerBase(Double firstOperand, Double secondOperand)
    {
        mFirstOperand = firstOperand;
        mSecondOperand = secondOperand;

        mOperandCount = OperandCount.TWO_OPERANDS.GetCount();
    }

    /**
     * @return the operation type.
     */
    @Override
    public abstract OperationType GetOperationType();

    /**
     * @return result of the operation.
     */
    @Override
    public abstract double ExecuteOperation();

    /**
     * @return operation symbol.
     */
    @Override
    public abstract char GetOperationSymbol();

    /**
     * @return the number of operands.
     */
    @Override
    public int GetNumberOfOperands() {
        return mOperandCount;
    }
}
