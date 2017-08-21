package com.sebkun.plc2java.diagram.blocks.bitShift;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.Map;

/**
 * @author sebkun
 */
public class SHL extends FunctionBlock {

    public SHL(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    @Override
    public Map<String, Connector> execute() {
        return null;
    }
}
