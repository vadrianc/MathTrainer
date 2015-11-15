package com.adrianconstantin.mathtrainer.test;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.OperationType;
import com.adrianconstantin.mathtrainer.exception.TestFinishedException;
import com.adrianconstantin.mathtrainer.integer.IntegerAdditionHandler;
import com.adrianconstantin.mathtrainer.integer.IntegerDivisionHandler;
import com.adrianconstantin.mathtrainer.integer.IntegerMultiplicationHandler;
import com.adrianconstantin.mathtrainer.integer.IntegerSubtractionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalAdditionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalDivisionHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalMultiplicationHandler;
import com.adrianconstantin.mathtrainer.natural.NaturalSubtractionHanlder;
import com.adrianconstantin.mathtrainer.setting.OperandType;
import com.adrianconstantin.mathtrainer.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by AdrianConstantin on 11/10/2015.
 */
public class CustomTest implements ITest, Parcelable {
    /**
     *
     */
    private List<Pair<OperandType, OperationType>> mOperationDescriptors;

    /**
     *
     */
    private List<IOperationHandler> mOperations = new ArrayList<IOperationHandler>();

    /**
     *
     */
    private int mOperationCount = 1;

    /**
     *
     */
    private int mMaxOperationCount = Utils.MAX_TEST_QUESTIONS;

    /**
     *
     */
    private ITestResult mResult;

    /**
     *
     * @param operationDescriptors
     */
    public CustomTest(List<Pair<OperandType, OperationType>> operationDescriptors, int maxOperationCount){
        mOperationDescriptors = operationDescriptors;
        mMaxOperationCount = maxOperationCount;
        mOperationCount = 0;
        mResult = new CustomResult();
        GenerateOperations();
    }

    public CustomTest(Parcel in) {
        mOperations = in.readArrayList(IOperationHandler.class.getClassLoader());
        mMaxOperationCount = in.readInt();
        mOperationCount = 0;
        mResult = new CustomResult();
    }

    public static final Creator<CustomTest> CREATOR = new Creator<CustomTest>() {
        @Override
        public CustomTest createFromParcel(Parcel in) {
            return new CustomTest(in);
        }

        @Override
        public CustomTest[] newArray(int size) {
            return new CustomTest[size];
        }
    };

    /**
     * @return
     */
    @Override
    public IOperationHandler GetNextOperation() throws TestFinishedException {
        if (IsFinished()){
            throw new TestFinishedException("Text has finished. No more operations can be generated.");
        }

        Random random = new Random();
        mOperationCount++;
        return mOperations.get(random.nextInt(4));
    }

    /**
     * @return
     */
    @Override
    public boolean IsFinished() {
        return mOperationCount == mMaxOperationCount;
    }

    /**
     * @return
     */
    @Override
    public String GetProgress() {
        return String.format("%d / %d", mOperationCount, mMaxOperationCount);
    }

    /**
     * @return
     */
    @Override
    public ITestResult GetResult() {
        return mResult;
    }

    /**
     *
     */
    private void GenerateOperations(){
        for (Pair<OperandType, OperationType> pair : mOperationDescriptors){
            if (pair.first == OperandType.NATURAL){
                createNaturalHandler(pair.second);
            }
            else if (pair.first == OperandType.INTEGER) {
                createIntegerHandler(pair.second);
            }
        }
    }

    /**
     *
     * @param type
     */
    private void createNaturalHandler(OperationType type){
        switch (type) {
            case ADDITION:
                mOperations.add(new NaturalAdditionHandler());
                break;
            case SUBSTRACTION:
                mOperations.add(new NaturalSubtractionHanlder());
                break;
            case MULTIPLICATION:
                mOperations.add(new NaturalMultiplicationHandler());
                break;
            case DIVISION:
                mOperations.add(new NaturalDivisionHandler());
                break;
        }
    }

    /**
     *
     * @param type
     */
    private void createIntegerHandler(OperationType type) {
        switch (type) {
            case ADDITION:
                mOperations.add(new IntegerAdditionHandler());
                break;
            case SUBSTRACTION:
                mOperations.add(new IntegerSubtractionHandler());
                break;
            case MULTIPLICATION:
                mOperations.add(new IntegerMultiplicationHandler());
                break;
            case DIVISION:
                mOperations.add(new IntegerDivisionHandler());
                break;
        }
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
        dest.writeList(mOperations);
        dest.writeInt(mMaxOperationCount);
    }
}
