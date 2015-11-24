package com.adrianconstantin.mathtrainer.setting;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public enum OperandType {
    /**
     * Natural number type.
     */
    NATURAL(1),

    /**
     * Integer number type.
     */
    INTEGER(2),

    /**
     * Real number type.
     */
    REAL(3);

    public static OperandType ToOperandType(int value)
    {
        switch (value) {
            case 1: return NATURAL;
            case 2: return INTEGER;
            case 3: return REAL;
            default: throw new UnsupportedOperationException();
        }
    }

    /**
     *
     */
    private int mValue;

    /**
     *
     * @param value
     */
    private OperandType(int value) {
        mValue = value;
    }

    public int GetValue(){
        return mValue;
    }
}
