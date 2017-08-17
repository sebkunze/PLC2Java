package com.sebkun.plc2java.diagram.blocks;

/**
 * @author sebkun
 */
public abstract class FunctionBlock implements Comparable<FunctionBlock> {

    protected int executionOrderId;

    public FunctionBlock(int executionOrderId) {
        this.executionOrderId = executionOrderId;
    }

    public abstract void execute();

    @Override
    public int compareTo(FunctionBlock func) {

        return Integer.valueOf(this.getExecutionOrderId()).compareTo(func.getExecutionOrderId());
    }

    public int getExecutionOrderId() {
        return executionOrderId;
    }
}