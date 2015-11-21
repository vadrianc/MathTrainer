package com.adrianconstantin.mathtrainer.base;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public abstract class OperationHandlerBase<T extends Number, R extends IRandomGenerator<T>, P extends OperandParserBase<T>>
        implements IOperationHandler<T, R> {
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
    protected R mRandomGenerator;

    /**
     *
     */
    protected P mOperandParser;

    /**
     *
     */
    public OperationHandlerBase() {

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
     *
     */
    public abstract void GenerateOperands();

    /**
     *
     */
    protected abstract void CreateRandomOperands();

    /**
     *
     * @return
     */
    public abstract String GetOperationName();

    /**
     *
     * @return
     */
    public abstract int GetResultMaxLength();

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
    public String GetExpression() {
        StringBuilder expression = new StringBuilder();

        expression.append(mOperandParser.GetFirstOperandString());
        expression.append(' ');
        expression.append(GetOperationSymbol());
        expression.append(' ');
        expression.append(mOperandParser.GetSecondOperandString());

        return expression.toString();
    }

    /**
     *
     * @param generator
     */
    public void SetRandomGenerator(R generator) {
        mRandomGenerator = generator;
    }
}
