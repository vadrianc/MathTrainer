package com.adrianconstantin.mathtrainer.integer;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.natural.NaturalSquarePowerHandler;

/**
 * Created by AdrianConstantin on 11/22/2015.
 */
public class IntegerSquarePowerHandler extends NaturalSquarePowerHandler implements Parcelable {
    /**
     *
     */
    public IntegerSquarePowerHandler(){
        super();
    }

    /**
     *
     * @param in
     */
    protected IntegerSquarePowerHandler(Parcel in) {
        super(in);
        mOperandParser = new IntegerOperandParser(this);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IntegerSquarePowerHandler> CREATOR = new Creator<IntegerSquarePowerHandler>() {
        @Override
        public IntegerSquarePowerHandler createFromParcel(Parcel in) {
            return new IntegerSquarePowerHandler(in);
        }

        @Override
        public IntegerSquarePowerHandler[] newArray(int size) {
            return new IntegerSquarePowerHandler[size];
        }
    };

    /**
     *
     */
    @Override
    public void GenerateOperands(){
        CreateRandomOperands();
        SignGenerator.ApplySignToFirstOperand(this);
        mOperandParser = new IntegerOperandParser(this);
    }

    /**
     * @return
     */
    @Override
    public int GetResultMaxLength() {
        return super.GetResultMaxLength() + 1;
    }
}
