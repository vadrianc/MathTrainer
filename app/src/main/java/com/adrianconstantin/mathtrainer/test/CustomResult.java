package com.adrianconstantin.mathtrainer.test;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdrianConstantin on 11/15/2015.
 */
public class CustomResult implements ITestResult, Parcelable {
    /**
     *
     */
    private List<String> mCorrectAnswerList;

    /**
     *
     */
    private List<String> mIncorrectAnswerList;

    /**
     *
     */
    public CustomResult(){
        mCorrectAnswerList = new ArrayList<String>();
        mIncorrectAnswerList = new ArrayList<String>();
    }

    /**
     *
     * @param in
     */
    protected CustomResult(Parcel in) {
        mCorrectAnswerList = new ArrayList<String>();
        mIncorrectAnswerList = new ArrayList<String>();

        in.readStringList(mCorrectAnswerList);
        in.readStringList(mIncorrectAnswerList);
    }

    public static final Creator<CustomResult> CREATOR = new Creator<CustomResult>() {
        @Override
        public CustomResult createFromParcel(Parcel in) {
            return new CustomResult(in);
        }

        @Override
        public CustomResult[] newArray(int size) {
            return new CustomResult[size];
        }
    };

    /**
     * @return
     */
    @Override
    public String GetCorrectAnswers() {
        return buildAnswerString(mCorrectAnswerList);
    }

    /**
     * @return
     */
    @Override
    public String GetIncorrectAnswers() {
        return buildAnswerString(mIncorrectAnswerList);
    }

    private String buildAnswerString(List<String> answerList){
        StringBuilder strBuilder = new StringBuilder();

        for (String answer : answerList){
            if (answer.contains("<html>")) {
                answer = answer.replace("<html>", "");
                answer = answer.replace("</html>", "");
                answer += "<br>";
                strBuilder.append(answer);
            }
            else {
                strBuilder.append(answer);
                strBuilder.append("\n");
            }
        }

        return strBuilder.toString();
    }

    /**
     *
     * @param exercise
     * @param answer
     */
    @Override
    public void PutCorrectAnswer(String exercise, String answer) {
        mCorrectAnswerList.add(String.format("%s = %s", exercise, answer));
    }

    /**
     *
     * @param exercise
     * @param answer
     * @param expectedAnswer
     */
    @Override
    public void PutIncorrectAnswer(String exercise, String answer, String expectedAnswer) {
        mIncorrectAnswerList.add(String.format("%s = %s (expected %s)", exercise, answer, expectedAnswer));
    }

    /**
     * @return
     */
    @Override
    public String GetCustomMessage() {
        StringBuilder msgBuilder = new StringBuilder();

        if (mIncorrectAnswerList.size() == 0) {
            msgBuilder.append("Congratulations! All your answers are correct.");
        } else {
            int total = mCorrectAnswerList.size() + mIncorrectAnswerList.size();

            msgBuilder.append("You answered correctly ");
            msgBuilder.append(mCorrectAnswerList.size());
            msgBuilder.append(" out of ");
            msgBuilder.append(total);
            msgBuilder.append('.');
            msgBuilder.append("\n");

            if (mCorrectAnswerList.size() >= 7){
                msgBuilder.append("Consider taking the test multiple times to improve your skills.");
            } else {
                msgBuilder.append("Consider practicing on individual operations before taking the test.");
            }
        }

        return msgBuilder.toString();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(mCorrectAnswerList);
        dest.writeStringList(mIncorrectAnswerList);
    }
}
