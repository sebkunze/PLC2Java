package com.sebkun.plc2java.diagram.blocks.arithmetic;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.INT;
import jdk.internal.util.xml.impl.Input;

import java.util.Map;

/**
 * @author sebkun
 */
public class ADD extends FunctionBlock {

    public static final String INPUT_IN   = "IN%d";

    public static final String OUTPUT_OUT = "OUT";

    public ADD(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    public ADD(int localId, int executionOrderId, Map<String, Connector> inputMap, Map<String, Connector> outputMap) {
        super(localId, executionOrderId);

        setInputs(inputMap);
        setOutputs(outputMap);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (!(getInput(String.format(INPUT_IN, 1)) instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!",
                            getInput(String.format(INPUT_IN, 1).getClass().getSimpleName())));
        }

        if (!(getOutput(String.format(OUTPUT_OUT, 1)) instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for output type %s!",
                            getOutput(String.format(OUTPUT_OUT, 1).getClass().getSimpleName())));
        }

        setOutputValue(OUTPUT_OUT, getInputValue(String.format(INPUT_IN, 1)));

        if (getInputs().size() >= 2) {

            for (int i = 1; i < getInputs().size(); i++) {

                Connector in = getInput(String.format(INPUT_IN, i + 1));

                setOutputValue(OUTPUT_OUT, getOutput(OUTPUT_OUT).add(in));
            }
        }

        return getOutputs();
    }
}