package com.sebkun.plc2java.parser.objects.tree.variables;

import com.sebkun.plc2java.parser.objects.tree.XMLVariable;

/**
 * @author sebkun
 */
public class XMLInOutVariable extends XMLVariable {

    private Boolean negatedIn;

    private Boolean negatedOut;

    public XMLInOutVariable(Integer localID, Integer executionOrder, Boolean negatedIn, Boolean negatedOut) {
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

        if (!(obj instanceof XMLInOutVariable)) {
            return false;
        }

        XMLInOutVariable v = (XMLInOutVariable) obj;

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