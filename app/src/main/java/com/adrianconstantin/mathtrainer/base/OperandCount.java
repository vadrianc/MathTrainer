package com.adrianconstantin.mathtrainer.base;

/**
 * Created by AdrianConstantin on 10/28/2015.
 */
public enum OperandCount {
    /**
     *
     */
    ONE_OPERAND(1),

    /**
     *
     */
    TWO_OPERANDS(2);

    /**
     *
     */
    private int mValue;

    /**
     *
     * @param value
     */
    OperandCount(int value)
    {
        mValue = value;
    }

    /**
     *
     * @return
     */
    public int GetCount(){
        return mValue;
    }
}
