package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

import java.util.Map;

/**
 * @author sebkun
 */
public class NE extends FunctionBlock {

    public static final String INPUT_IN1  = "IN1";

    public static final String INPUT_IN2  = "IN2";

    public static final String OUTPUT_OUT = "OUT";

    public NE(int executionOrderId, Connector in1, Connector in2, Connector out) {
        super(executionOrderId);

        this.setInput(INPUT_IN1, in1);
        this.setInput(INPUT_IN2, in2);

        this.setOutput(OUTPUT_OUT, out);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        Connector out = getInputs().get(NE.INPUT_IN1).ne(getInputs().get(NE.INPUT_IN2));

        updateOutput(NE.OUTPUT_OUT, out);

        return outputs;
    }
}