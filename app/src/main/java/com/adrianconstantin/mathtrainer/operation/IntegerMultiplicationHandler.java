package com.adrianconstantin.mathtrainer.operation;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.MultiplicationHandlerBase;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class IntegerMultiplicationHandler extends MultiplicationHandlerBase<Integer, IntegerRandomGenerator> implements Parcelable{
    /**
     *
     */
    public IntegerMultiplicationHandler(){
        super();
    }

    /**
     *
     * @param in
     */
    protected IntegerMultiplicationHandler(Parcel in) {
        mFirstOperand = in.readInt();
        mSecondOperand = in.readInt();
    }

    /**
     *
     */
    public static final Creator<IntegerMultiplicationHandler> CREATOR = new Creator<IntegerMultiplicationHandler>() {
        @Override
        public IntegerMultiplicationHandler createFromParcel(Parcel in) {
            return new IntegerMultiplicationHandler(in);
        }

        @Override
        public IntegerMultiplicationHandler[] newArray(int size) {
            return new IntegerMultiplicationHandler[size];
        }
    };

    /**
     * @return result of the operation.
     */
    @Override
    public Integer ExecuteOperation() {
        return mFirstOperand * mSecondOperand;
    }

    /**
     * @return
     */
    @Override
    protected boolean CanExecute() {
        return false;
    }

    /**
     *
     */
    @Override
    public void GenerateOperands() {

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
