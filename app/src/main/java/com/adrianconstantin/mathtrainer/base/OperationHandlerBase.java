package com.adrianconstantin.mathtrainer.base;

import java.util.List;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public abstract class OperationHandlerBase<T extends Number> implements IOperationHandler<T> {
    /**
     * First operand.
     */
    protected T mFirstOperand;

    /**
     * Second operand.
     */
    protected T mSecondOperand;

    /**
     *
     */
    protected int mOperandCount;

    /**
     *
     */
    protected IRandomGenerator<T> mRandomGenerator;

    /**
     *
     */
    public OperationHandlerBase()
    {
    }

    /**
     *
     */
    public OperationHandlerBase(T firstOperand)
    {
        mFirstOperand = firstOperand;

        mOperandCount = OperandCount.ONE_OPERAND.GetCount();
    }

    /**
     *
     */
    public OperationHandlerBase(T firstOperand, T secondOperand)
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
    public abstract T ExecuteOperation();

    /**
     *
     * @return
     */
    protected abstract boolean CanExecute();

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

    /**
     *
     * @return
     */
    public T GetFirstOperand()
    {
        return mFirstOperand;
    }

    /**
     *
     * @return
     */
    public T GetSecondOperand()
    {
        return mSecondOperand;
    }

    /**
     *
     * @param value
     */
    @Override
    public void SetFirstOperand(T value) {
        mFirstOperand = value;
    }

    /**
     *
     * @param value
     */
    @Override
    public void SetSecondOperand(T value){
        mSecondOperand = value;
    }

    /**
     *
     * @return
     */
    public String GetExpression(){
        StringBuilder expression = new StringBuilder();

        expression.append(mFirstOperand.intValue());
        expression.append(' ');
        expression.append(GetOperationSymbol());
        expression.append(' ');
        expression.append(mSecondOperand.intValue());

        return expression.toString();
    }

    public void SetRandomGenerator(IRandomGenerator<T> generator) {
        mRandomGenerator = generator;
    }

    private void generateOperands() {
        mFirstOperand = mRandomGenerator.Generate();
    }
}
