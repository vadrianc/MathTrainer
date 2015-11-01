package com.adrianconstantin.mathtrainer.base;

/**
 * Created by AdrianConstantin on 11/1/2015.
 */
public interface IRandomGenerator<T extends Number> {
    /**
     * @return the random generated number.
     */
    T Generate();
}
