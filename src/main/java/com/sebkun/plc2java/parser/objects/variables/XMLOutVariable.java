package com.sebkun.plc2java.parser.objects.variables;

import com.sebkun.plc2java.parser.objects.XMLVariable;

/**
 * @author sebkun
 */
public class XMLOutVariable extends XMLVariable {

    public XMLOutVariable(int localID, int executionOrder, boolean negated) {
        super(localID, executionOrder, negated);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof XMLOutVariable))
            return false;

        XMLVariable v = (XMLOutVariable) obj;

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