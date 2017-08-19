package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
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

    public LE(int executionOrderId, List<Connector> inputList, Connector out) {
        super(executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);

        this.setOutput(OUTPUT_OUT, out);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            updateOutput(LE.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector<Boolean> out = new BOOL(true);

            Connector tmp = getInputs().get("IN1");

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(LE.INPUT_IN_PATTERN + String.valueOf(i + 1));

                // check if pairs is not less equals.
                if (!tmp.gt(in).getValue()) {

                    // update output.
                    out = new BOOL(false);

                    // stop iterating input pairs.
                    break;
                }

                // continue with next pair of inputs.
                tmp = in;
            }

            updateOutput(LE.OUTPUT_OUT, out);
        }
        return outputs;
    }
}