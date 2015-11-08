package com.adrianconstantin.mathtrainer.natural;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.SubstractionHandlerBase;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;
import com.adrianconstantin.mathtrainer.utils.Utils;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class NaturalSubtractionHanlder extends SubstractionHandlerBase<Integer, IntegerRandomGenerator, NaturalOperandParser>
        implements Parcelable {
    /**
     *
     */
    public NaturalSubtractionHanlder() {
        super();
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(OperationSettings.Instance().GetmMaximumDigits()));
        GenerateOperands();
        mOperandParser = new NaturalOperandParser(this);
    }

    /**
     *
     * @param in
     */
    protected NaturalSubtractionHanlder(Parcel in) {
        this();
        mFirstOperand = in.readInt();
        mSecondOperand = in.readInt();
    }

    /**
     *
     */
    public static final Creator<NaturalSubtractionHanlder> CREATOR = new Creator<NaturalSubtractionHanlder>() {
        @Override
        public NaturalSubtractionHanlder createFromParcel(Parcel in) {
            return new NaturalSubtractionHanlder(in);
        }

        @Override
        public NaturalSubtractionHanlder[] newArray(int size) {
            return new NaturalSubtractionHanlder[size];
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
     *
     */
    @Override
    public void GenerateOperands() {
        do {
            mFirstOperand = mRandomGenerator.Generate();
            mSecondOperand = mRandomGenerator.Generate();
        } while (ExecuteOperation() < 0);
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
