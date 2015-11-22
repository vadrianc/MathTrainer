package com.adrianconstantin.mathtrainer.integer;

import android.os.Parcel;
import android.os.Parcelable;

import com.adrianconstantin.mathtrainer.natural.NaturalAdditionHandler;
import com.adrianconstantin.mathtrainer.setting.OperationSettings;

/**
 * Created by AdrianConstantin on 11/8/2015.
 */
public class IntegerAdditionHandler extends NaturalAdditionHandler implements Parcelable {
    public IntegerAdditionHandler(){
        super();
    }

    public IntegerAdditionHandler(Parcel in) {
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
