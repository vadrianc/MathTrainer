package com.adrianconstantin.mathtrainer.setting;

/**
 * Created by AdrianConstantin on 11/21/2015.
 */
public enum OperationDifficulty {

    EASY(1),

    NORMAL(2),

    HARD(3);

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
