package com.sebkun.plc2java.parser.objects.tree.functions;

import com.sebkun.plc2java.parser.objects.tree.XMLFunction;

/**
 * @author sebkun
 */
public class XMLBlock extends XMLFunction {

    public XMLBlock(Integer localId, String typeName, Integer executionOrder) {
        super(localId, typeName, executionOrder);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof XMLBlock)) {
            return false;
        }

        XMLBlock b = (XMLBlock) obj;

        if (!this.localId.equals(b.getLocalId())
                || !this.typeName.equals(b.getTypeName())
                || !this.executionOrderID.equals(b.getExecutionOrderID())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}