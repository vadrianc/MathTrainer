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
        ApplySignToFirstOperand(handler);
        ApplySignToSecondOperand(handler);
    }

    /**
     *
     * @param handler
     */
    public static void ApplySignToFirstOperand(IOperationHandler handler){
        Integer firstOperand = (Integer)handler.GetFirstOperand();

        int number = sRand.nextInt();
        if (number % 2 != 0) {
            firstOperand *= (-1);
        }

        handler.SetFirstOperand(firstOperand);
    }

    /**
     *
     * @param handler
     */
    public static void ApplySignToSecondOperand(IOperationHandler handler) {
        Integer secondOperand = (Integer)handler.GetSecondOperand();

        int number = sRand.nextInt();
        if (number % 2 != 0) {
            secondOperand *= (-1);
        }

        handler.SetSecondOperand(secondOperand);
    }
}
