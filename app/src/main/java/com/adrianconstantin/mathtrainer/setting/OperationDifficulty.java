package com.adrianconstantin.mathtrainer.setting;

/**
 * Created by AdrianConstantin on 11/21/2015.
 */
public enum OperationDifficulty {

    EASY(1),

    NORMAL(2),

    HARD(3);

    public static OperationDifficulty ToOperationDifficulty(int value){
        switch (value){
            case 1: return EASY;
            case 2: return NORMAL;
            case 3: return HARD;
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
    private OperationDifficulty(int value) {
        mValue = value;
    }

    public int GetValue(){
        return mValue;
    }
}
