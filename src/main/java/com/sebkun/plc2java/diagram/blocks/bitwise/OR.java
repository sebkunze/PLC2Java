package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

import java.util.Map;

/**
 * @author sebkun
 */
public class OR extends FunctionBlock {

    // --- INPUTS --

    public static final String INPUT_IN  = "IN%d";

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT = "OUT";

    // --- CONSTRUCTOR ---

    public OR(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    public OR(int localId, int executionOrderId, Map<String, Connector> inputMap, Map<String, Connector> outputMap) {
        super(localId, executionOrderId);

        setInputs(inputMap);
        setOutputs(outputMap);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            setOutputValue(OUTPUT_OUT, true);
        } else {

            setOutputValue(OUTPUT_OUT, getInput(String.format(INPUT_IN, 1)).getValue());

            for (int i = 0; i < getInputs().size(); i++) {

                Connector in = getInputs().get(String.format(OR.INPUT_IN, i + 1));

                setOutputValue(OUTPUT_OUT, getOutput(OUTPUT_OUT).or(in));
            }
        }

        return outputs;
    }
}