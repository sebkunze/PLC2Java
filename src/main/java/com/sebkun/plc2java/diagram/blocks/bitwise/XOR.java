package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

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

        if (getInputs().size() == 1) {

            updateOutput(OR.OUTPUT_OUT, new BOOL(true));
        } else {

            updateOutput(XOR.OUTPUT_OUT, inputs.values().stream().reduce(inputs.get("IN1").not(), (p, q) -> ((p.and(q.not())).or(q.and(p.not())))));
        }

        return outputs;
    }
}