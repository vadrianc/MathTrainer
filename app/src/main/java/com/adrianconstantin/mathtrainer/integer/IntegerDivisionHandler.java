package com.adrianconstantin.mathtrainer.integer;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.natural.NaturalDivisionHandler;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class IntegerDivisionHandler extends NaturalDivisionHandler implements Parcelable {
    public IntegerDivisionHandler() {
        super();
    }

    public IntegerDivisionHandler(Parcel in) {
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
