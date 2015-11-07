package com.adrianconstantin.mathtrainer.operation;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.DivisionHandlerBase;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class IntegerDivisionHandler extends DivisionHandlerBase<Integer> implements Parcelable {
    /**
     *
     */
    public IntegerDivisionHandler(){
        super();
    }

    /**
     *
     * @param in
     */
    protected IntegerDivisionHandler(Parcel in) {
    }

    /**
     *
     */
    public static final Creator<IntegerDivisionHandler> CREATOR = new Creator<IntegerDivisionHandler>() {
        @Override
        public IntegerDivisionHandler createFromParcel(Parcel in) {
            return new IntegerDivisionHandler(in);
        }

        @Override
        public IntegerDivisionHandler[] newArray(int size) {
            return new IntegerDivisionHandler[size];
        }
    };

    /**
     * @return result of the operation.
     */
    @Override
    public Integer ExecuteOperation() {
        return null;
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
