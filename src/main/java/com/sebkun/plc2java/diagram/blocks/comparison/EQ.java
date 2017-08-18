package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
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

    private static final String INPUT_IN_PATTERN = "IN";

    public EQ(int executionOrderId, List<Connector> inputList) {
        super(executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);
    }

    @Override
    public Map<String, Connector> execute() {

        if (getInputs().size() < 2) {

            updateOutput(EQ.OUTPUT_OUT, new BOOL(true));
        } else {

            Connector con = getInputs().get("IN1");

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(EQ.INPUT_IN_PATTERN + String.valueOf(i));

                con = con.eq(in);
            }
            updateOutput(EQ.OUTPUT_OUT, con);
        }
        return outputs;
    }
}