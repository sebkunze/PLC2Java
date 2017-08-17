package com.sebkun.plc2java.parser.objects.functions;

import com.sebkun.plc2java.parser.objects.XMLFunction;

/**
 * @author sebkun
 */
public class XMLBlock extends XMLFunction {

    public static final String ATTRIBUTE_INPUT_VARIABLES  = "inputVariables";

    public static final String ATTRIBUTE_INOUT_VARIABLES  = "inOutVariables";

    public static final String ATTRIBUTE_OUTPUT_VARIABLES = "outputVariables";

    public static final String ATTRIBUTE_REF_LOCAL_ID     = "refLocalId";

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