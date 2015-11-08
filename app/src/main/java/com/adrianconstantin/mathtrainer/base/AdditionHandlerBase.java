package com.adrianconstantin.mathtrainer.base;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public abstract class AdditionHandlerBase<T extends Number, R extends IRandomGenerator<T>, P extends OperandParserBase<T>>
        extends OperationHandlerBase<T, R, P> {
    /**
     *
     */
    public AdditionHandlerBase() {
        super();
    }

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.ADDITION;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '+';
    }
}