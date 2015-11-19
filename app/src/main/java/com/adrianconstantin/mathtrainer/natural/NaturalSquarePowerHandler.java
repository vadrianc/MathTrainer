package com.adrianconstantin.mathtrainer.natural;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.PowerHandlerBase;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;
import com.adrianconstantin.mathtrainer.utils.Utils;

/**
 * Created by AdrianConstantin on 11/19/2015.
 */
public class NaturalSquarePowerHandler extends PowerHandlerBase<Integer, IntegerRandomGenerator, NaturalOperandParser>
        implements Parcelable {

    /**
     *
     */
    private final int RESULT_MAX_LENGTH = 3;

    /**
     *
     */
    public NaturalSquarePowerHandler(){
        super();
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(OperationSettings.Instance().GetmMaximumDigits()));
        mSecondOperand = 2;
        GenerateOperands();
    }

    /**
     *
     * @param in
     */
    protected NaturalSquarePowerHandler(Parcel in) {
        super();
        mFirstOperand = in.readInt();
        mSecondOperand = 2;
        mOperandParser = new NaturalOperandParser(this);
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(OperationSettings.Instance().GetmMaximumDigits()));
    }

    /**
     *
     */
    public static final Creator<NaturalSquarePowerHandler> CREATOR = new Creator<NaturalSquarePowerHandler>() {
        @Override
        public NaturalSquarePowerHandler createFromParcel(Parcel in) {
            return new NaturalSquarePowerHandler(in);
        }

        @Override
        public NaturalSquarePowerHandler[] newArray(int size) {
            return new NaturalSquarePowerHandler[size];
        }
    };

    /**
     * @return result of the operation.
     */
    @Override
    public Integer ExecuteOperation() {
        return ((Double)Math.pow(mFirstOperand, mSecondOperand)).intValue();
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
        CreateRandomOperands();

        mOperandParser = new NaturalOperandParser(this);
    }

    /**
     * @return
     */
    @Override
    public int GetResultMaxLength() {
        return RESULT_MAX_LENGTH;
    }

    /**
     *
     */
    @Override
    protected void CreateRandomOperands() {
        mFirstOperand = mRandomGenerator.Generate();
    }

    /**
     * @return
     */
    @Override
    public String GetOperationName() {
        return Utils.SQUARE_POWER;
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
        dest.writeInt(mFirstOperand);
    }
}
