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
public class EQ extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT        = "OUT";

    // --- PATTERNS ---

    private static final String INPUT_IN_PATTERN = "IN"; // TODO: Implement pattern.

    public EQ(int executionOrderId, List<Connector> inputList, Connector out) { // TODO: add constructor without executionID
        super(executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);

        this.setOutput(OUTPUT_OUT, out);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            updateOutput(EQ.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector<Boolean> out = new BOOL(true);

            Connector tmp = getInputs().get("IN1");

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(EQ.INPUT_IN_PATTERN + String.valueOf(i + 1));

                // check if pairs are non-equivalent.
                if (!tmp.eq(in).getValue()) {

                    // update output.
                    out = new BOOL(false);

                    // stop iterating input pairs.
                    break;
                }

                // continue with next pair of inputs.
                tmp = in;
            }

            updateOutput(EQ.OUTPUT_OUT, out);
        }
        return outputs;
    }
}