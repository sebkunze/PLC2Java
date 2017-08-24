package com.sebkun.plc2java.parser.objects.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sebkun
 */
public abstract class XMLFunction {

    protected Integer localId;

    protected String typeName;

    protected Integer executionOrderID;

    protected Map<String, Integer> inputVariables;

    protected Map<String, Integer> inOutVariables;

    protected Map<String, Integer> outputVariables;

    public XMLFunction(Integer localId, String typeName, Integer executionOrderID) {

        this.localId          = localId;
        this.typeName         = typeName;
        this.executionOrderID = executionOrderID;

        inputVariables  = new HashMap<>();
        inOutVariables  = new HashMap<>();
        outputVariables = new HashMap<>();
    }

    public Integer getLocalId() {
        return this.localId;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public Integer getExecutionOrderID() {
        return this.executionOrderID;
    }

    public Map<String, Integer> getInputVariables() {
        return inputVariables;
    }

    public void setInputVariable(String key, Integer value) {

        this.inputVariables.put(key, value);
    }

    public Map<String, Integer> getInOutVariables() {

        return inOutVariables;
    }

    public void setInOutVariable(String key, Integer value) {

        this.inOutVariables.put(key, value);
    }

    public Map<String, Integer> getOutputVariables() {

        return outputVariables;
    }

    public void setOutputVariable(String key, Integer value) {

        this.outputVariables.put(key, value);
    }
}