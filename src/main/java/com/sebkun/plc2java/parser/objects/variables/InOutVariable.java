package com.sebkun.plc2java.parser.objects.variables;

import com.sebkun.plc2java.parser.objects.Variable;

/**
 * @author sebkun
 */
public class InOutVariable extends Variable {

    private Boolean negatedIn;

    private Boolean negatedOut;

    public InOutVariable(Integer localID, Integer executionOrder, Boolean negatedIn, Boolean negatedOut) {
        super(localID, executionOrder, null);

        this.negatedIn  = negatedIn;
        this.negatedOut = negatedOut;
    }

    public Boolean isNegatedIn() {
        return this.negatedIn;
    }

    public Boolean isNegatedOut() {
        return this.negatedOut;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof InOutVariable)) {
            return false;
        }

        InOutVariable v = (InOutVariable) obj;

        if (!this.localID.equals(v.getLocalID())
                || !this.executionOrderID.equals(v.getExecutionOrderID())
                || !this.negated.equals(v.isNegated())
                || !this.negatedIn.equals(v.isNegatedIn())
                || !this.negatedOut.equals(v.isNegatedOut())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}