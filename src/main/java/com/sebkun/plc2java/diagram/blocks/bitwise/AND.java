package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.blocks.comparison.EQ;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public class AND extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT        = "OUT";

    // --- PATTERNS ---

    private static final String INPUT_IN_PATTERN = "IN";

    public AND(int executionOrderID, List<Connector> ins, Connector out) {
        super(executionOrderID);

        this.setInputList(INPUT_IN_PATTERN, ins);

        this.setOutput(OUTPUT_OUT, out);
    }

    public BOOL getOutput() {

        return (BOOL) this.getOutputs().get(AND.OUTPUT_OUT);
    }

    public Boolean getOutputValue() {

        return getOutput().getValue();
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            updateOutput(AND.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector con = getInputs().get("IN1");

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(AND.INPUT_IN_PATTERN + String.valueOf(i + 1));

                con = con.and(in);
            }
            updateOutput(EQ.OUTPUT_OUT, con);
        }
        return outputs;
    }
}