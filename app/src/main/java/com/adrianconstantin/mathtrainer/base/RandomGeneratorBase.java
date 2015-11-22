package com.adrianconstantin.mathtrainer.base;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by AdrianConstantin on 11/1/2015.
 */
public abstract class RandomGeneratorBase<T extends Number> implements IRandomGenerator<T> {
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
     * RandomGeneratorBase constructor.
     *
     * @param seed  the initial value of the internal state of the pseudorandom number generator
     *              which is maintained by method next(int).
     * @param maximum limit for the generated number.
     */
    public RandomGeneratorBase(long seed, int maximum)
    {
        mRandom = new Random(seed);
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
