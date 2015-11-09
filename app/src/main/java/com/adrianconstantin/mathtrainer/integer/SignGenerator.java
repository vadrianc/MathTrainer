package com.adrianconstantin.mathtrainer.integer;

import com.adrianconstantin.mathtrainer.base.IOperationHandler;

import java.util.Random;

/**
 * Created by AdrianConstantin on 11/9/2015.
 */
public class SignGenerator {
    public static void ApplySignsToIntegers(IOperationHandler handler){
        Integer firstOperand = (Integer)handler.GetFirstOperand();
        Integer secondOperand = (Integer)handler.GetSecondOperand();

        Random randSign = new Random(1);
        boolean isPlus = randSign.nextBoolean();

        if (!isPlus) {
            firstOperand = -1 * firstOperand;
        }

        isPlus = randSign.nextBoolean();

        if (!isPlus){
            secondOperand = -1 * secondOperand;
        }

        handler.SetFirstOperand(firstOperand);
        handler.SetSecondOperand(secondOperand);
    }
}
