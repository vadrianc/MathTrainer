package com.adrianconstantin.mathtrainer.natural;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.AdditionHandlerBase;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;
import com.adrianconstantin.mathtrainer.utils.Utils;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class NaturalAdditionHandler extends AdditionHandlerBase<Integer, IntegerRandomGenerator, NaturalOperandParser>
        implements Parcelable {

    /**
     *
     */
    private final int RESULT_MAX_LENGTH = 3;

    /**
     *
     */
    public NaturalAdditionHandler() {
        super();
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(OperationSettings.Instance().GetmMaximumDigits()));
        GenerateOperands();
    }

    /**
     *
     * @param in
     */
    public NaturalAdditionHandler(Parcel in) {
        super();
        mFirstOperand = in.readInt();
        mSecondOperand = in.readInt();
        mOperandParser = new NaturalOperandParser(this);
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(OperationSettings.Instance().GetmMaximumDigits()));
    }

    /**
     *
     */
    public static final Creator<NaturalAdditionHandler> CREATOR = new Creator<NaturalAdditionHandler>() {
        @Override
        public NaturalAdditionHandler createFromParcel(Parcel in) {
            return new NaturalAdditionHandler(in);
        }

        @Override
        public NaturalAdditionHandler[] newArray(int size) {
            return new NaturalAdditionHandler[size];
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
        CreateRandomOperands();

        mOperandParser = new NaturalOperandParser(this);
    }

    /**
     *
     */
    protected void CreateRandomOperands(){
        mFirstOperand = mRandomGenerator.Generate();
        mSecondOperand = mRandomGenerator.Generate();
    }

    /**
     * @return
     */
    @Override
    public int GetResultMaxLength() {
        return RESULT_MAX_LENGTH;
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
        dest.writeInt(mSecondOperand);
    }
}
