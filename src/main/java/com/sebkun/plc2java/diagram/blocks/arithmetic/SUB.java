package com.sebkun.plc2java.diagram.blocks.arithmetic;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.Map;

/**
 * @author sebkun
 */
public class SUB extends FunctionBlock {

    public SUB(int executionOrderId) {
        super(executionOrderId);
    }

    @Override
    public Map<String, Connector> execute() {
        return null;
    }
}