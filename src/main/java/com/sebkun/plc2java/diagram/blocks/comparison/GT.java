package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.Map;

/**
 * @author sebkun
 */
public class GT extends FunctionBlock {

    // --- INPUTS --

    public static final String INPUT_IN   = "IN%d";

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT = "OUT";

    // --- CONSTRUCTOR ---

    public GT(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    public GT(int localId, int executionOrderId, Map<String, Connector> inputMap, Map<String, Connector> outputMap) {
        super(localId, executionOrderId);

        setInputs(inputMap);
        setOutputs(outputMap);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            setOutputValue(OUTPUT_OUT, true);
        } else {

            Connector<Boolean> out = new BOOL(-1, true);

            Connector tmp = getInputs().get(String.format(GT.INPUT_IN, 1));

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInputs().get(String.format(GT.INPUT_IN, i + 1));

                if (!tmp.gt(in)) {
                    out = new BOOL(0, false);
                }

                tmp = in;
            }

            setOutputValue(OUTPUT_OUT, out.getValue());
        }

        return getOutputs();
    }
}