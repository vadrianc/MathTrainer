package com.adrianconstantin.mathtrainer.operation;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.AdditionHandlerBase;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class IntegerAdditionHandler extends AdditionHandlerBase<Integer, IntegerRandomGenerator> implements Parcelable {
    /**
     *
     */
    public IntegerAdditionHandler() {
        super();
    }

    /**
     *
     * @param in
     */
    public IntegerAdditionHandler(Parcel in) {
        mFirstOperand = in.readInt();
        mSecondOperand = in.readInt();
    }

    /**
     *
     */
    public static final Creator<IntegerAdditionHandler> CREATOR = new Creator<IntegerAdditionHandler>() {
        @Override
        public IntegerAdditionHandler createFromParcel(Parcel in) {
            return new IntegerAdditionHandler(in);
        }

        @Override
        public IntegerAdditionHandler[] newArray(int size) {
            return new IntegerAdditionHandler[size];
        }
    };

    /**
     * @return result of the operation.
     */
    @Override
    public Integer ExecuteOperation() {
        return mFirstOperand + mSecondOperand;
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
