package com.adrianconstantin.mathtrainer.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.OperationHandlerBase;
import com.adrianconstantin.mathtrainer.base.OperationType;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public class MultiplicationHandler extends OperationHandlerBase implements Parcelable{
    /**
     *
     */
    public MultiplicationHandler(){

    }

    /**
     *
     * @param firstOperand
     * @param secondOperand
     */
    public MultiplicationHandler(Double firstOperand, Double secondOperand) {
        super(firstOperand, secondOperand);
    }

    protected MultiplicationHandler(Parcel in) {
    }

    public static final Creator<MultiplicationHandler> CREATOR = new Creator<MultiplicationHandler>() {
        @Override
        public MultiplicationHandler createFromParcel(Parcel in) {
            return new MultiplicationHandler(in);
        }

        @Override
        public MultiplicationHandler[] newArray(int size) {
            return new MultiplicationHandler[size];
        }
    };

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.MULTIPLICATION;
    }

    /**
     * @return result of the operation.
     */
    @Override
    public double ExecuteOperation() {
        return mFirstOperand * mSecondOperand;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '*';
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
