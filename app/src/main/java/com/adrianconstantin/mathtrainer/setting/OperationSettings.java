package com.adrianconstantin.mathtrainer.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by AdrianConstantin on 11/7/2015.
 */
public class OperationSettings {

    private final String DIFFICULTY = "Difficulty";
    private final String MAXIMUM_DIGITS = "Maximum digits";
    private final String OPERAND_TYPE = "Operand Type";
    private final String IS_NOTIFICATION_ENABLED = "Notification Enabled";
    private final String HOUR = "Hour";
    private final String MINUTE = "Minute";
    private final String IS_AM = "Am";


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
     *
     */
    private boolean mIsNotificationEnabled;

    /**
     *
     */
    private int mHour;

    /**
     *
     */
    private int mMinute;

    /**
     *
     */
    private boolean mIsAm;

    /**
     *
     */
    private boolean mDoAdRequest;

    /**
     * OperationSettings default constructor.
     */
    public OperationSettings() {
        mOperandType = OperandType.NATURAL;
        mOperationDifficulty = OperationDifficulty.NORMAL;
        mMaximumDigits = 2;
        mIsNotificationEnabled = true;
        mHour = 18;
        mMinute = 0;
        mIsAm = false;
        mDoAdRequest = false;
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

    /**
     *
     * @return
     */
    public boolean GetIsNotificationEnabled() {
        return mIsNotificationEnabled;
    }

    /**
     *
     * @param mIsNotificationEnabled
     */
    public void SetIsNotificationEnabled(boolean mIsNotificationEnabled) {
        this.mIsNotificationEnabled = mIsNotificationEnabled;
    }

    /**
     *
     * @return
     */
    public int GetHour() {
        return mHour;
    }

    /**
     *
     * @param hour
     */
    public void SetHour(int hour) {
        this.mHour = hour;
    }

    /**
     *
     * @return
     */
    public int GetMinute() {
        return mMinute;
    }

    /**
     *
     * @param minute
     */
    public void SetMinute(int minute) {
        this.mMinute = minute;
    }

    /**
     *
     * @return
     */
    public boolean GetIsAm() {
        return mIsAm;
    }

    /**
     *
     * @param isAm
     */
    public void SetIsAm(boolean isAm) {
        this.mIsAm = isAm;
    }

    /**
     *
     * @return
     */
    public boolean DoAdRequest() {
        return mDoAdRequest;
    }

    /**
     *
     * @return
     */
    public String GetTime(){
        if (mHour <= 9 && mMinute <= 9) return String.format("0%d : 0%d", mHour, mMinute);
        if (mMinute <= 9) return String.format("%d : 0%d", mHour, mMinute);
        if (mHour <= 9) return String.format("0%d : %d", mHour, mMinute);

        return String.format("%d : %d", mHour, mMinute);
    }

    /**
     *
     */
    public void SaveOptions(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(DIFFICULTY, mOperationDifficulty.GetValue());
        editor.putInt(MAXIMUM_DIGITS, mMaximumDigits);
        editor.putInt(OPERAND_TYPE, mOperandType.GetValue());
        editor.putBoolean(IS_NOTIFICATION_ENABLED, mIsNotificationEnabled);
        editor.putInt(HOUR, mHour);
        editor.putInt(MINUTE, mMinute);
        editor.putBoolean(IS_AM, mIsAm);

        editor.commit();
    }

    /**
     *
     */
    public void LoadOptions(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        int difficultyValue = preferences.getInt(DIFFICULTY, OperationDifficulty.NORMAL.GetValue());
        mOperationDifficulty = OperationDifficulty.ToOperationDifficulty(difficultyValue);

        mMaximumDigits = preferences.getInt(MAXIMUM_DIGITS, 2);

        int operandTypeValue = preferences.getInt(OPERAND_TYPE, OperandType.NATURAL.GetValue());
        mOperandType = OperandType.ToOperandType(operandTypeValue);

        mIsNotificationEnabled = preferences.getBoolean(IS_NOTIFICATION_ENABLED, true);
        mHour = preferences.getInt(HOUR, 6);
        mMinute = preferences.getInt(MINUTE, 0);
        mIsAm = preferences.getBoolean(IS_AM, false);
    }
}
