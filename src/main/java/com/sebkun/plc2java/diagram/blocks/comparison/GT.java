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
public class GT extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT          = "OUT";

    // --- PATTERNS ---

    private static final String INPUT_IN_PATTERN = "IN%d";

    public GT(int localId, int executionOrderId, List<Connector> inputList, Connector out) {
        super(localId, executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);

        this.setOutput(OUTPUT_OUT, out);
    }

    public BOOL getOutput() {

        return (BOOL) getOutputs().get(GT.OUTPUT_OUT);
    }

    public Boolean getOutputValue() {

        return getOutput().getValue();
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            updateOutput(GT.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector<Boolean> out = new BOOL(true);

            Connector tmp = getInputs().get(String.format(GT.INPUT_IN_PATTERN, 1));

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(String.format(GT.INPUT_IN_PATTERN, i + 1));

                // check if pairs is not greater than.
                if (!tmp.gt(in).getValue()) {

                    // update output.
                    out = new BOOL(false);

                    // stop iterating input pairs.
                    break;
                }

                // continue with next pair of inputs.
                tmp = in;
            }

            updateOutput(GT.OUTPUT_OUT, out);
        }
        return outputs;
    }
}