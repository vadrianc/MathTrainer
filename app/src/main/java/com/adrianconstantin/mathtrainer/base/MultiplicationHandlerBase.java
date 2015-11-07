package com.adrianconstantin.mathtrainer.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public abstract class MultiplicationHandlerBase<T extends Number, R extends IRandomGenerator<T>> extends OperationHandlerBase<T, R> {
    /**
     *
     */
    public MultiplicationHandlerBase() {

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
}
