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
     *
     * @param minimum
     * @param maximum
     */
    public IntegerRandomGenerator(int minimum, int maximum)
    {
        super(minimum, maximum);
    }

    /**
     * @return
     */
    @Override
    protected Integer GenerateNumber() {
        if (mMinimum != NO_MIN_VALUE) {
            return mRandom.nextInt(mMaximum - mMinimum) + mMinimum;
        }

        return mRandom.nextInt(mMaximum);
    }
}
