package com.sebkun.plc2java.diagram.blocks.arithmetic;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.Map;

/**
 * @author sebkun
 */
public class MOD extends FunctionBlock {

    public MOD(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    @Override
    public Map<String, Connector> execute() {
        return null;
    }
}