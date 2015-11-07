package com.adrianconstantin.mathtrainer.base;

import java.util.Random;

/**
 * Created by AdrianConstantin on 11/1/2015.
 */
public abstract class RandomGeneratorBase<T extends Number> implements IRandomGenerator<T> {
    /**
     * Random generator.
     */
    protected Random mRandom = null;

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
    }

    /**
     * Generated random number.
     *
     * @return the random number.
     */
    @Override
    public abstract T Generate();

    /**
     *
     * @return
     */
    public int GetMaximum(){
        return mMaximum;
    }
}
