package com.adrianconstantin.mathtrainer.impl;

import com.adrianconstantin.mathtrainer.base.RandomGeneratorBase;

/**
 * Created by AdrianConstantin on 11/1/2015.
 */
public class IntegerRandomGenerator extends RandomGeneratorBase<Integer> {
    /**
     * IntegerRandomGenerator constructor.
     *
     * @param maximum limit for the generated integer.
     */
    public IntegerRandomGenerator(Integer maximum)
    {
        super(maximum);
    }

    /**
     * IntegerRandomGenerator constructor.
     *
     * @param seed  the initial value of the internal state of the pseudorandom integer generator
     *              which is maintained by method next(int).
     * @param maximum limit for the generated number.
     */
    public IntegerRandomGenerator(long seed, Integer maximum)
    {
        super(seed, maximum);
    }

    /**
     * Generated random integer.
     *
     * @return the random integer.
     */
    @Override
    public Integer Generate() {
        return mRandom.nextInt(mMaximum);
    }
}
