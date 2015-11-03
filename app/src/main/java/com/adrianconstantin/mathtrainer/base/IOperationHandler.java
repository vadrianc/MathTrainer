package com.adrianconstantin.mathtrainer.base;

import java.util.List;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public interface IOperationHandler {
    /**
     *
     * @return
     */
    Double GetFirstOperand();

    /**
     *
     * @return
     */
    Double GetSecondOperand();

    /**
     * @return the operation type.
     */
    OperationType GetOperationType();

    /**
     * @return result of the operation.
     */
    double ExecuteOperation();

    /**
     * @return the number of operands.
     */
    int GetNumberOfOperands();

    /**
     * @return operation symbol.
     */
    char GetOperationSymbol();
}
