package com.adrianconstantin.mathtrainer.generator;

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
    public IntegerRandomGenerator(int maximum)
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
    public IntegerRandomGenerator(long seed, int maximum)
    {
        super(seed, maximum);
    }

    /**
     * @return
     */
    @Override
    protected Integer GenerateNumber() {
        return mRandom.nextInt(mMaximum);
    }
}
