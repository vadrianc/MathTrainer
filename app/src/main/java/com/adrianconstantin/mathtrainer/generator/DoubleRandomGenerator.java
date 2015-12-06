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
     * @return
     */
    @Override
    protected Double GenerateNumber() {
        return mRandom.nextInt(mMaximum) * mRandom.nextDouble();
    }
}
