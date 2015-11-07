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
     * The maximum number of digits a single operand can have.
     */
    private int mMaximumDigits;

    /**
     * OperationSettings default constructor.
     */
    public OperationSettings() {
        mOperandType = OperandType.NATURAL;
        mMaximumDigits = 2;
    }

    /**
     * Getter for the operand type field.
     *
     * @return
     */
    public OperandType GetmOperandType() {
        return mOperandType;
    }

    /**
     * Setter for the operand type field.
     *
     * @param mOperandType
     */
    public void SetmOperandType(OperandType mOperandType) {
        this.mOperandType = mOperandType;
    }

    /**
     * Getter for the maximum number of digits for an operand.
     *
     * @return the maximum number of digits for an operand.
     */
    public int GetmMaximumDigits() {
        return mMaximumDigits;
    }

    /**
     * Setter for the maximum number of digits for an operand.
     *
     * @param mMaximumDigits
     */
    public void SetmMaximumDigits(int mMaximumDigits) {
        this.mMaximumDigits = mMaximumDigits;
    }
}
