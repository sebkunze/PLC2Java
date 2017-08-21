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
public class OR extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT        = "OUT";

    // --- PATTERNS ---

    private static final String PATTERN_INPUT_IN = "IN%d";

    public OR(int localId, int executionOrderId, List<Connector> inputList, Connector out) {
        super(localId, executionOrderId);

        this.setInputList(PATTERN_INPUT_IN, inputList);

        this.setOutput(OUTPUT_OUT, out);
    }

    public BOOL getOutput() {

        return (BOOL) getOutputs().get(OR.OUTPUT_OUT);
    }

    public Boolean getOutputValue() {

        return getOutput().getValue();
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            updateOutput(OR.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector con = getInputs().get(String.format(OR.PATTERN_INPUT_IN, 1));

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(String.format(OR.PATTERN_INPUT_IN, i + 1));

                con = con.or(in);
            }
            updateOutput(OR.OUTPUT_OUT, con);
        }
        return outputs;
    }
}