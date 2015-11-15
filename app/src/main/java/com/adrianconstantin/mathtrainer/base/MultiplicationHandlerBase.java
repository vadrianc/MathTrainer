package com.adrianconstantin.mathtrainer.base;

import com.adrianconstantin.mathtrainer.utils.Utils;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public abstract class MultiplicationHandlerBase<T extends Number, R extends IRandomGenerator<T>, P extends OperandParserBase<T>>
        extends OperationHandlerBase<T, R, P> {
    /**
     *
     */
    public MultiplicationHandlerBase() {
        super();
    }

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.MULTIPLICATION;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '*';
    }

    /**
     * @return
     */
    @Override
    public String GetOperationName() {
        return Utils.MULTIPLICATION;
    }
}
