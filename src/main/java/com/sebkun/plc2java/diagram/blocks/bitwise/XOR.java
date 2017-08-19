package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

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

    public BOOL getOutput() {

        return (BOOL) getOutputs().get(XOR.OUTPUT_OUT);
    }

    public Boolean getOutputValue() {

        return getOutput().getValue();
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            updateOutput(XOR.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector con = getInputs().get("IN1");

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(XOR.INPUT_IN_PATTERN + String.valueOf(i + 1));

                con = (con.and(in.not())).or(in.and(con.not()));
            }
            updateOutput(XOR.OUTPUT_OUT, con);
        }
        return outputs;
    }
}