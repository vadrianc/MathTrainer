package com.adrianconstantin.mathtrainer.base;

import java.util.List;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public interface IOperationHandler<T extends Number> {
    /**
     *
     * @return
     */
    T GetFirstOperand();

    /**
     *
     * @return
     */
    T GetSecondOperand();

    /**
     *
     * @param value
     */
    void SetFirstOperand(T value);

    /**
     *
     * @param value
     */
    void SetSecondOperand(T value);

    /**
     * @return the operation type.
     */
    OperationType GetOperationType();

    /**
     * @return result of the operation.
     */
    T ExecuteOperation();

    /**
     * @return the number of operands.
     */
    int GetNumberOfOperands();

    /**
     * @return operation symbol.
     */
    char GetOperationSymbol();

    /**
     *
     * @return
     */
    String GetExpression();

    /**
     *
     * @param generator
     */
    void SetRandomGenerator(IRandomGenerator<T> generator);
}
