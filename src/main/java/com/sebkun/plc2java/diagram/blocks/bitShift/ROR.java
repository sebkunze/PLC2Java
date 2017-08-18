package com.sebkun.plc2java.diagram.blocks.bitShift;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.Map;

/**
 * @author sebkun
 */
public class ROR extends FunctionBlock {

    public ROR(int executionOrderId) {
        super(executionOrderId);
    }

    @Override
    public Map<String, Connector> execute() {
        return null;
    }
}