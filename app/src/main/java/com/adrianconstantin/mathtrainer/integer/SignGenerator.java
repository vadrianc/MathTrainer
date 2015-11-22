package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;

import java.util.Random;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class SignGenerator {
    /**
     *
     */
    private static Random sRand = new Random(100);

    /**
     *
     * @param handler
     */
    public static void ApplySignsToIntegers(IOperationHandler handler){
        Integer firstOperand = (Integer)handler.GetFirstOperand();
        Integer secondOperand = (Integer)handler.GetSecondOperand();

        int number = sRand.nextInt();
        if (number % 2 != 0) {
            firstOperand *= (-1);
        }

        number = sRand.nextInt();
        if (number % 2 != 0) {
            secondOperand *= (-1);
        }

        handler.SetFirstOperand(firstOperand);
        handler.SetSecondOperand(secondOperand);
    }
}
