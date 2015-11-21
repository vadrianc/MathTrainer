package com.adrianconstantin.mathtrainer.base;

/**
 * Created by AdrianConstantin on 11/19/2015.
 */
public abstract class PowerHandlerBase<T extends Number, R extends IRandomGenerator<T>, P extends OperandParserBase<T>>
        extends OperationHandlerBase<T, R, P> {
    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.POWER;
    }

    /**
     * @return operation symbol.
     */
    @Override
    public char GetOperationSymbol() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String GetExpression() {
        StringBuilder expression = new StringBuilder();

        expression.append("<html>");
        expression.append(mOperandParser.GetFirstOperandString());
        expression.append("<sup><small>");
        expression.append(mOperandParser.GetSecondOperandString());
        expression.append("</small></sup>");
        expression.append("</html>");

        return expression.toString();
    }
}
