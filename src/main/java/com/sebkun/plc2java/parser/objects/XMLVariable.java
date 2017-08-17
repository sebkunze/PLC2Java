package com.sebkun.plc2java.parser.objects;

/**
 * @author sebkun
 */
public abstract class XMLVariable {

    protected Integer localID;

    protected Integer executionOrderID;

    protected Boolean negated;

    protected String expression;

    public XMLVariable(Integer localID, Integer executionOrder, Boolean negated) {

        if (localID == null || executionOrder == null) {
            throw new NullPointerException();
        }

        this.localID          = localID;
        this.executionOrderID = executionOrder;
        this.negated          = negated;
    }

    public Integer getLocalID() {
        return localID;
    }

    public Integer getExecutionOrderID() {
        return executionOrderID;
    }

    public Boolean isNegated() {
        return negated;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}