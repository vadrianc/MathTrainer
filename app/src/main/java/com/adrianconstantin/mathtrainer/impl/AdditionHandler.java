package com.adrianconstantin.mathtrainer.impl;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.OperandCount;
import com.adrianconstantin.mathtrainer.base.OperationHandlerBase;
import com.adrianconstantin.mathtrainer.base.OperationType;

import java.util.List;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public class AdditionHandler extends OperationHandlerBase implements Parcelable {
    /**
     *
     */
    public AdditionHandler() {

    }

    protected AdditionHandler(Parcel in) {
        super(in.readDouble(), in.readDouble());
        mOperandCount = in.readInt();

    }

    public static final Creator<AdditionHandler> CREATOR = new Creator<AdditionHandler>() {
        @Override
        public AdditionHandler createFromParcel(Parcel in) {
            return new AdditionHandler(in);
        }

        @Override
        public AdditionHandler[] newArray(int size) {
            return new AdditionHandler[size];
        }
    };

    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.ADDITION;
    }

    /**
     * @return result of the operation.
     */
    @Override
    public double ExecuteOperation() {
        return mFirstOperand + mSecondOperand;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return '+';
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