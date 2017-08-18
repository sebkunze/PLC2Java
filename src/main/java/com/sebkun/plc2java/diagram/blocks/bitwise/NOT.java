package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.Map;

/**
 * @author sebkun
 */
public class NOT extends FunctionBlock {

    // --- INPUTS --

    private static final String INPUT_IN  = "IN";

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT = "OUT";

    public NOT(int executionOrderId, Connector in, Connector out) {
        super(executionOrderId);

        setInput(INPUT_IN, in);

        setOutput(OUTPUT_OUT, out);
    }

    @Override
    public Map<String, Connector> execute() {

        this.updateOutput(
                NOT.OUTPUT_OUT,
                inputs.get(INPUT_IN).not());

        return outputs;
    }
}