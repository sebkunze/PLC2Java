package com.sebkun.plc2java.diagram.blocks;

import java.util.Map;

/**
 * @author sebkun
 */
public abstract class Block {

    protected int executionOrderId;

    public Block(int executionOrderId) {
        this.executionOrderId = executionOrderId;
    }

    public int getExecutionOrderId() {
        return executionOrderId;
    }

    public abstract Map<String, Integer> execute();
}