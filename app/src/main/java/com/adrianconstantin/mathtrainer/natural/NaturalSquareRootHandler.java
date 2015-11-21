package com.adrianconstantin.mathtrainer.natural;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.base.RootHandlerBase;
import com.adrianconstantin.mathtrainer.generator.IntegerRandomGenerator;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;
import com.adrianconstantin.mathtrainer.utils.Utils;

/**
 * Created by AdrianConstantin on 11/20/2015.
 */
public class NaturalSquareRootHandler extends RootHandlerBase<Integer, IntegerRandomGenerator, NaturalOperandParser>
        implements Parcelable {

    /**
     *
     */
    public NaturalSquareRootHandler(){
        super();
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(2));
        mSecondOperand = 2;
        GenerateOperands();
    }

    protected NaturalSquareRootHandler(Parcel in) {
        super();
        mFirstOperand = in.readInt();
        mSecondOperand = 2;
        mOperandParser = new NaturalOperandParser(this);
        mRandomGenerator = new IntegerRandomGenerator(Utils.GetMaximumInteger(2));
    }

    public static final Creator<NaturalSquareRootHandler> CREATOR = new Creator<NaturalSquareRootHandler>() {
        @Override
        public NaturalSquareRootHandler createFromParcel(Parcel in) {
            return new NaturalSquareRootHandler(in);
        }

        @Override
        public NaturalSquareRootHandler[] newArray(int size) {
            return new NaturalSquareRootHandler[size];
        }
    };

    /**
     * @return result of the operation.
     */
    @Override
    public Integer ExecuteOperation() {
        return ((Double)Math.sqrt(mFirstOperand)).intValue();
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
        return OperationSettings.Instance().GetMaximumDigits();
    }

    /**
     *
     */
    @Override
    protected void CreateRandomOperands() {
        mFirstOperand = ((Double)Math.pow(mRandomGenerator.Generate(), 2)).intValue();
    }

    /**
     * @return
     */
    @Override
    public String GetOperationName() {
        return Utils.SQUARE_ROOT;
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
