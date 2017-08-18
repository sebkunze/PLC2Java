package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public class LE extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT          = "OUT";

    // --- PATTERNS ---

    private static final String INPUT_IN_PATTERN = "IN";

    public LE(int executionOrderId, List<Connector> inputList) {
        super(executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);
    }

    @Override
    public Map<String, Connector> execute() {

        if (getInputs().size() < 2) {

            updateOutput(LE.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector con = getInputs().get("IN1");

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(LE.INPUT_IN_PATTERN + String.valueOf(i));

                con = con.le(in);
            }
            updateOutput(LE.OUTPUT_OUT, con);
        }
        return outputs;
    }
}