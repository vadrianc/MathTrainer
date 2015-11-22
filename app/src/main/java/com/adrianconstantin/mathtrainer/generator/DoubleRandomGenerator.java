package com.adrianconstantin.mathtrainer.generator;

import com.adrianconstantin.mathtrainer.base.RandomGeneratorBase;

/**
 * Created by AdrianConstantin on 11/2/2015.
 */
public class DoubleRandomGenerator extends RandomGeneratorBase<Double> {
    /**
     * DoubleRandomGenerator constructor.
     *
     * @param maximum limit for the generated double.
     */
    public DoubleRandomGenerator(int maximum)
    {
        super(maximum);
    }

    /**
     * DoubleRandomGenerator constructor.
     *
     * @param seed    the initial value of the internal state of the pseudorandom double generator
     *                which is maintained by method next(int).
     * @param maximum limit for the generated double.
     */
    public DoubleRandomGenerator(long seed, int maximum) {
        super(seed, maximum);
    }

    /**
     * @return
     */
    @Override
    protected Double GenerateNumber() {
        return mRandom.nextInt(mMaximum) * mRandom.nextDouble();
    }
}
