package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.blocks.bitwise.AND;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public class GE extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT          = "OUT";

    // --- PATTERNS ---

    private static final String INPUT_IN_PATTERN = "IN%d";

    public GE(int localId, int executionOrderId, List<Connector> inputList, Connector out) {
        super(localId, executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);

        this.setOutput(OUTPUT_OUT, out);
    }

    public BOOL getOutput() {

        return (BOOL) getOutputs().get(GE.OUTPUT_OUT);
    }

    public Boolean getOutputValue() {

        return getOutput().getValue();
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            updateOutput(GE.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector<Boolean> out = new BOOL(true);

            Connector tmp = getInputs().get(String.format(GE.INPUT_IN_PATTERN, 1));

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(String.format(GE.INPUT_IN_PATTERN, i + 1));

                // check if pairs is not greater equals.
                if (!tmp.ge(in).getValue()) {

                    // update output.
                    out = new BOOL(false);

                    // stop iterating input pairs.
                    break;
                }

                // continue with next pair of inputs.
                tmp = in;
            }

            updateOutput(GE.OUTPUT_OUT, out);
        }
        return outputs;
    }
}