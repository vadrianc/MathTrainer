package com.adrianconstantin.mathtrainer.setting;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class OperationSettings {
    /**
     * Singleton instance.
     */
    private static OperationSettings sInstance;

    /**
     * @return singleton instance.
     */
    public static OperationSettings Instance()
    {
        if (sInstance == null)
        {
            sInstance = new OperationSettings();
        }

        return sInstance;
    }

    /**
     * The type of the operands.
     */
    private OperandType mOperandType;

    /**
     *
     */
    private int mMaximumDigits;

    /**
     *
     */
    private OperationDifficulty mOperationDifficulty;

    /**
     * OperationSettings default constructor.
     */
    public OperationSettings() {
        mOperandType = OperandType.NATURAL;
        mOperationDifficulty = OperationDifficulty.NORMAL;
        mMaximumDigits = 2;
    }

    /**
     * Getter for the operand type field.
     *
     * @return
     */
    public OperandType GetOperandType() {
        return mOperandType;
    }

    /**
     * Setter for the operand type field.
     *
     * @param mOperandType
     */
    public void SetOperandType(OperandType mOperandType) {
        this.mOperandType = mOperandType;
    }

    /**
     * Getter for the difficulty of the operation.
     *
     * @return the difficulty of the operation.
     */
    public OperationDifficulty GetOperationDifficulty() {
        return mOperationDifficulty;
    }

    /**
     * Setter for the difficulty of the operation.
     *
     * @param difficulty
     */
    public void SetOperationDifficulty(OperationDifficulty difficulty) {
        mOperationDifficulty = difficulty;
        mMaximumDigits = mOperationDifficulty.GetValue();
    }

    /**
     *
     * @return
     */
    public int GetMaximumDigits(){
        return mMaximumDigits;
    }
}
