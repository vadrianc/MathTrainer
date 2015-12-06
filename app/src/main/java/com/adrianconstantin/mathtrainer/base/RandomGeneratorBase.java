package com.adrianconstantin.mathtrainer.base;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by AdrianConstantin on 11/1/2015.
 */
public abstract class RandomGeneratorBase<T extends Number> implements IRandomGenerator<T> {
    public final int NO_MIN_VALUE = -1;

    protected final int MAX_HISTORY_CAPACITY = 7;

    /**
     * Random generator.
     */
    protected Random mRandom = null;

    /**
     * The list of previously generated values.
     */
    protected ArrayBlockingQueue<T> mHistory;

    /**
     * The maximum limit for the generated number.
     */
    protected int mMaximum = 0;

    /**
     * The maximum limit for the generated number.
     */
    protected int mMinimum = NO_MIN_VALUE;

    /**
     * RandomGeneratorBase constructor.
     *
     * @param maximum limit for the generated number.
     */
    public RandomGeneratorBase(int maximum)
    {
        mRandom = new Random();
        mMaximum = maximum;
        mHistory = new ArrayBlockingQueue<T>(MAX_HISTORY_CAPACITY);
    }

    /**
     *
     * @param minimum
     * @param maximum
     */
    public RandomGeneratorBase(int minimum, int maximum)
    {
        mRandom = new Random();
        mMinimum = minimum;
        mMaximum = maximum;
        mHistory = new ArrayBlockingQueue<T>(MAX_HISTORY_CAPACITY);
    }

    /**
     * Generated random number.
     *
     * @return the random number.
     */
    @Override
    public T Generate() {
        T result;
        final int maxAttempts = 50;
        int currentAttempt = 0;

        do {
            result = GenerateNumber();
            currentAttempt++;
            if (currentAttempt == maxAttempts) break;
        }
        while (mHistory.contains(result));

        if (mHistory.size() == MAX_HISTORY_CAPACITY){
            mHistory.poll();
        }

        mHistory.add(result);

        return result;
    }

    /**
     *
     * @return
     */
    protected abstract T GenerateNumber();

    /**
     *
     * @return
     */
    public int GetMaximum(){
        return mMaximum;
    }

    /**
     *
     * @param maximum
     */
    public void SetMaximum(int maximum){
        mMaximum = maximum;
    }
}
