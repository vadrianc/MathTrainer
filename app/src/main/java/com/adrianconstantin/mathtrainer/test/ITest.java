package com.adrianconstantin.mathtrainer.test;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.exception.TestFinishedException;

/**
 * Created by AdrianConstantin on 11/10/2015.
 */
public interface ITest {
    /**
     *
     * @return
     */
    IOperationHandler GetNextOperation() throws TestFinishedException;

    /**
     *
     * @return
     */
    boolean IsFinished();

    /**
     *
     * @return
     */
    String GetProgress();

    /**
     *
     * @return
     */
    ITestResult GetResult();
}
