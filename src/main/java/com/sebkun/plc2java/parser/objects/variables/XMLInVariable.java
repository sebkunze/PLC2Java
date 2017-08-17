package com.sebkun.plc2java.parser.objects.variables;

import com.sebkun.plc2java.parser.objects.XMLVariable;

/**
 * @author sebkun
 */
public class XMLInVariable extends XMLVariable {

    public XMLInVariable(Integer localID, Integer executionOrder, Boolean negated) {
        super(localID, executionOrder, negated);
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof XMLInVariable)) {
            return false;
        }

        XMLInVariable v = (XMLInVariable) obj;

        if(!this.localID.equals(v.getLocalID())
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