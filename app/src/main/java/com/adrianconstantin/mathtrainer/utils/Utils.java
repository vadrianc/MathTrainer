package com.adrianconstantin.mathtrainer.utils;

/**
 * Created by AdrianConstantin on 11/3/2015.
 */
public class Utils {
    /**
     *
     */
    private static final char BASE_FOR_MAX = '9';

    /**
     * Operation type constant.
     */
    public static final String OPERATION = "Operation";

    /**
     *
     * @param length
     * @return
     */
    public static Integer GetMaximumInteger(int length){
        StringBuilder maxBuilder = new StringBuilder();

        for (int index = 0; index < length; index++){
            maxBuilder.append(BASE_FOR_MAX);
        }

        return Integer.parseInt(maxBuilder.toString());
    }
}
