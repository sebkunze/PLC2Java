package com.sebkun.plc2java.diagram.blocks.standard;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.blocks.FunctionBlock;

import java.util.Map;

/**
 * @author sebkun
 */
public class TOF extends FunctionBlock {

    public static final String INPUT_IN  = "IN";

    public static final String INPUT_PT  = "PT";

    public static final String OUPUT_Q   = "Q";

    public static final String OUTPUT_ET = "ET";

    public TOF(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    @Override
    public Map<String, Connector> execute() {
        return null;
    }
}