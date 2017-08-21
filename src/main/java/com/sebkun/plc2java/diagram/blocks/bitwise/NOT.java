package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.Map;

/**
 * @author sebkun
 */
public class NOT extends FunctionBlock {

    // --- INPUTS --

    private static final String INPUT_IN  = "IN1";

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT = "OUT";

    public NOT(int localId, int executionOrderId, Connector in, Connector out) {
        super(localId, executionOrderId);

        setInput(INPUT_IN, in);

        setOutput(OUTPUT_OUT, out);
    }

    public BOOL getOutput() {

        return (BOOL) getOutputs().get(NOT.OUTPUT_OUT);
    }

    public Boolean getOutputValue() {

        return getOutput().getValue();
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        Connector con = inputs.get(INPUT_IN).not();

        this.updateOutput(NOT.OUTPUT_OUT, con);

        return outputs;
    }
}