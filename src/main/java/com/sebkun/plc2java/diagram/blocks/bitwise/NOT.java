package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

import java.util.Map;

/**
 * @author sebkun
 */
public class NOT extends FunctionBlock {

    // --- INPUTS --

    public static final String INPUT_IN  = "IN1";

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT = "OUT";

    // --- CONSTRUCTOR ---

    public NOT(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    public NOT(int localId, int executionOrderId, Map<String, Connector> inputMap, Map<String, Connector> outputMap) {
        super(localId, executionOrderId);

        setInputs(inputMap);
        setOutputs(outputMap);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        setOutputValue(OUTPUT_OUT, getInput(INPUT_IN).not());

        return getOutputs();
    }
}