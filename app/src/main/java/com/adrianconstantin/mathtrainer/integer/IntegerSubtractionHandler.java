package com.adrianconstantin.mathtrainer.integer;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.natural.NaturalSubtractionHanlder;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class IntegerSubtractionHandler extends NaturalSubtractionHanlder implements Parcelable {
    public IntegerSubtractionHandler() {
        super();
    }

    public IntegerSubtractionHandler(Parcel in) {
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

    public static final Creator<IntegerSubtractionHandler> CREATOR = new Creator<IntegerSubtractionHandler>() {
        @Override
        public IntegerSubtractionHandler createFromParcel(Parcel in) {
            return new IntegerSubtractionHandler(in);
        }

        @Override
        public IntegerSubtractionHandler[] newArray(int size) {
            return new IntegerSubtractionHandler[size];
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
        return super.GetResultMaxLength() + 2;
    }
}
