package com.adrianconstantin.mathtrainer.test;

import android.util.Pair;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;
import com.adrianconstantin.mathtrainer.base.OperationType;
import com.adrianconstantin.mathtrainer.setting.OperandType;

import java.util.List;

/**
 * Created by AdrianConstantin on 11/10/2015.
 */
public interface ITest {
    /**
     *
     * @return
     */
    IOperationHandler GetNextOperation();

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
}
