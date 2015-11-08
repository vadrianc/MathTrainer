package com.adrianconstantin.mathtrainer.natural;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.DivisionHandlerBase;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;
import com.adrianconstantin.mathtrainer.utils.Utils;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class NaturalDivisionHandler extends DivisionHandlerBase<Integer, IntegerRandomGenerator, NaturalOperandParser>
        implements Parcelable {
    /**
     *
     */
    public NaturalDivisionHandler() {
        super();
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(OperationSettings.Instance().GetmMaximumDigits()));
        GenerateOperands();
        mOperandParser = new NaturalOperandParser(this);
    }

    /**
     *
     * @param in
     */
    protected NaturalDivisionHandler(Parcel in) {
        this();
        mFirstOperand = in.readInt();
        mSecondOperand = in.readInt();
    }

    /**
     *
     */
    public static final Creator<NaturalDivisionHandler> CREATOR = new Creator<NaturalDivisionHandler>() {
        @Override
        public NaturalDivisionHandler createFromParcel(Parcel in) {
            return new NaturalDivisionHandler(in);
        }

        @Override
        public NaturalDivisionHandler[] newArray(int size) {
            return new NaturalDivisionHandler[size];
        }
    };

    /**
     * @return result of the operation.
     */
    @Override
    public Integer ExecuteOperation() {
        return mFirstOperand / mSecondOperand;
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
        mFirstOperand = mRandomGenerator.Generate();
        int tempMax = mRandomGenerator.GetMaximum();

        if (mFirstOperand == 0 ||
                mFirstOperand == 1 ||
                mFirstOperand == 2) {
            mSecondOperand = 1;
            return;
        }

        mRandomGenerator.SetMaximum(mFirstOperand / 2);

        int tryRounds = 0;
        int maxTryRounds = 200;

        do {
            mSecondOperand = mRandomGenerator.Generate();
            tryRounds++;

            if (tryRounds >= maxTryRounds) {

                if (mSecondOperand == 0 || mFirstOperand % mSecondOperand != 0){
                    mSecondOperand = 1;
                }

                break;
            }
        } while (mSecondOperand == 0 ||
                mSecondOperand == 1 ||
                mFirstOperand % mSecondOperand != 0);

        mRandomGenerator.SetMaximum(tempMax);
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
