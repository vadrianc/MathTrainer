package com.adrianconstantin.mathtrainer.base;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public abstract class DivisionHandlerBase<T extends Number, R extends IRandomGenerator<T>> extends OperationHandlerBase<T, R> {
    /**
     *
     */
    public DivisionHandlerBase() {

    }

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.DIVISION;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '/';
    }
}
