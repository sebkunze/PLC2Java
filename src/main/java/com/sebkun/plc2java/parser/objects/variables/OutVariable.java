package com.sebkun.plc2java.parser.objects.variables;

import com.sebkun.plc2java.parser.objects.Variable;

/**
 * @author sebkun
 */
public class OutVariable extends Variable {

    public OutVariable(int localID, int executionOrder, boolean negated) {
        super(localID, executionOrder, negated);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof OutVariable))
            return false;

        Variable v = (OutVariable) obj;

        if (!this.localID.equals(v.getLocalID())
                || !this.executionOrderID.equals(v.getExecutionOrderID())
                || !this.negated.equals(v.isNegated())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}