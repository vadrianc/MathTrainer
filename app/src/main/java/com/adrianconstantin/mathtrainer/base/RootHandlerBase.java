package com.adrianconstantin.mathtrainer.base;

/**
 * Created by AdrianConstantin on 11/20/2015.
 */
public abstract class RootHandlerBase<T extends Number, R extends IRandomGenerator<T>, P extends OperandParserBase<T>>
        extends OperationHandlerBase<T, R, P> {
    /**
     * @return the operation type.
     */
    @Override
    public OperationType GetOperationType() {
        return OperationType.ROOT;
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

        expression.append("&radic;<span style=\"text-decoration: overline\"><small>");
        expression.append(mOperandParser.GetFirstOperandString());
        expression.append("</small></span>");

        return expression.toString();
    }
}
