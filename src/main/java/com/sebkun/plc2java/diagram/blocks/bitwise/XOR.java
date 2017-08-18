package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public class XOR extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT        = "OUT";

    // --- PATTERNS ---

    private static final String INPUT_IN_PATTERN = "IN";

    public XOR(int executionOrderId, List<Connector> inputList, Connector out) {
        super(executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);

        this.setOutput(OUTPUT_OUT, out);
    }

    @Override
    public Map<String, Connector> execute() {

        this.updateOutput(
                XOR.OUTPUT_OUT,
                this.inputs.values().stream().reduce(this.outputs.get(OUTPUT_OUT), (x,y) -> ((x.and(y.not())).or((x.not()).and(y)))));

        return outputs;
    }
}