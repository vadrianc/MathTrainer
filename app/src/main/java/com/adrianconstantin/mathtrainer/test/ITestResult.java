package com.adrianconstantin.mathtrainer.test;

/**
 * Created by AdrianConstantin on 11/15/2015.
 */
public interface ITestResult {
    /**
     *
     * @return
     */
    String GetCorrectAnswers();

    /**
     *
     * @return
     */
    String GetIncorrectAnswers();

    /**
     *
     * @param exercise
     * @param answer
     */
    void PutCorrectAnswer(String exercise, String answer);

    /**
     *
     * @param exercise
     * @param answer
     */
    void PutIncorrectAnswer(String exercise, String answer);
}
