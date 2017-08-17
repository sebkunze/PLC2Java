package com.sebkun.plc2java.diagram.blocks;

import java.util.Map;

/**
 * @author sebkun
 */
public abstract class FunctionBlock {

    protected int executionOrderId;

    public FunctionBlock(int executionOrderId) {
        this.executionOrderId = executionOrderId;
    }

    public int getExecutionOrderId() {
        return executionOrderId;
    }

    public abstract Map<String, Integer> execute();
}