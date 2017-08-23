package com.sebkun.plc2java.diagram.blocks;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public abstract class FunctionBlock {

    protected int localId;

    protected int executionOrderId;

    protected Map<String, Connector> inputs;

    protected Map<String, Connector> outputs;

    public FunctionBlock(int localId, int executionOrderId) {

        this.executionOrderId = executionOrderId;
        this.localId = localId;

        inputs  = Collections.EMPTY_MAP;
        outputs = Collections.EMPTY_MAP;
    }

    public int getExecutionOrderId() {
        return executionOrderId;
    }

    public Map<String, Connector> getInputs() {
        return inputs;
    }

    public Connector getInput(String key) {
        return inputs.get(key);
    }

    public Object getInputValue(String key) {
        return inputs.get(key).getValue();
    }

    public void setInputs(Map<String, Connector> inputs) {
        this.inputs = inputs;
    }

    public void setInput(String key, Connector value) {
        inputs.put(key, value);
    }

    public void setInputValue(String key, Object value) {
        inputs.get(key).setValue(value);
    }

    public Map<String, Connector> getOutputs() {
        return outputs;
    }

    public Connector getOutput(String key) {
        return outputs.get(key);
    }

    public Object getOutputValue(String key) {
        return outputs.get(key).getValue();
    }

    public void setOutputs(Map<String, Connector> outputs) {
        this.outputs = outputs;
    }

    public void setOutput(String key, Connector output) {
        outputs.put(key, output);
    }

    public void setOutputValue(String key, Object value) {
        outputs.get(key).setValue(value);
    }

    public abstract Map<String, Connector> execute()
            throws NonSupportedOperationException;

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof FunctionBlock)) {
            return false;
        }

        FunctionBlock block = (FunctionBlock) obj;

        if (this.getExecutionOrderId() == block.getExecutionOrderId()
                && this.getInputs() == block.getInputs()
                && this.getOutputs() == block.getOutputs()) {
            return true;
        }

        return false;
    }
}