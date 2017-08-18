package com.sebkun.plc2java.diagram.blocks;

import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public abstract class FunctionBlock {

    protected int executionOrderId;

    protected Map<String, Connector> inputs;

    protected Map<String, Connector> outputs;

    public FunctionBlock(int executionOrderId) {
        this.executionOrderId = executionOrderId;

        inputs  = new HashMap<>();
        outputs = new HashMap<>();
    }

    public int getExecutionOrderId() {
        return executionOrderId;
    }

    public abstract Map<String, Connector> execute();

    public Map<String, Connector> getInputs() {
        return inputs;
    }

    public void setInput(String key, Connector value) {
        this.inputs.put(key, value);
    }

    public void setInputList(String keyPrefix, List<Connector> values) {

        for (int i = 0; i < values.size(); i++) {

            String     key  = keyPrefix + String.valueOf(i + 1);
            Connector value = values.get(i);

            inputs.put(key, value);
        }
    }

    public Map<String, Connector> getOutputs() {
        return outputs;
    }

    public void updateOutput(String key, Connector connector) {
        this.outputs.get(key).setValue(connector.getValue());
    }

    public void setOutput(String key, Connector output) {
        this.outputs.put(key, output);
    }
}