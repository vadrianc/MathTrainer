package com.adrianconstantin.mathtrainer.operation;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.SubstractionHandlerBase;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class IntegerSubtractionHanlder extends SubstractionHandlerBase<Integer> implements Parcelable {
    /**
     *
     */
    public IntegerSubtractionHanlder(){
        super();
    }

    /**
     *
     * @param in
     */
    protected IntegerSubtractionHanlder(Parcel in) {
        mFirstOperand = in.readInt();
        mSecondOperand = in.readInt();
    }

    /**
     *
     */
    public static final Creator<IntegerSubtractionHanlder> CREATOR = new Creator<IntegerSubtractionHanlder>() {
        @Override
        public IntegerSubtractionHanlder createFromParcel(Parcel in) {
            return new IntegerSubtractionHanlder(in);
        }

        @Override
        public IntegerSubtractionHanlder[] newArray(int size) {
            return new IntegerSubtractionHanlder[size];
        }
    };

    /**
     * @return result of the operation.
     */
    @Override
    public Integer ExecuteOperation() {
        return mFirstOperand - mSecondOperand;
    }

    /**
     * @return
     */
    @Override
    protected boolean CanExecute() {
        return false;
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
