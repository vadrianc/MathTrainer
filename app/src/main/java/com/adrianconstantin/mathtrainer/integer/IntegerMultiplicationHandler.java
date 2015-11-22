package com.adrianconstantin.mathtrainer.integer;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.natural.NaturalMultiplicationHandler;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class IntegerMultiplicationHandler extends NaturalMultiplicationHandler implements Parcelable {
    public IntegerMultiplicationHandler() {
        super();
    }

    public IntegerMultiplicationHandler(Parcel in) {
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
     *
     */
    @Override
    public void GenerateOperands(){
        CreateRandomOperands();
        SignGenerator.ApplySignsToIntegers(this);
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
