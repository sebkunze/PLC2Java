package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author sebkun
 */
public class AND extends FunctionBlock {

    // --- INPUTS --

    public static final String INPUT_IN = "IN%d";

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT = "OUT";

    // --- CONSTRUCTOR ---

    public AND(int localId, int executionOrderId) {
        super(localId, executionOrderId);
    }

    public AND(int localId, int executionOrderID, Map<String, Connector> inputMap, Map<String, Connector> outputMap) {
        super(localId, executionOrderID);

        setInputs(inputMap);
        setOutputs(outputMap);
    }

    @Override
    public Map<String, Connector> execute()
            throws NonSupportedOperationException {

        if (getInputs().size() < 2) {

            setOutputValue(OUTPUT_OUT, true);
        } else {

            setOutputValue(OUTPUT_OUT, getInput(String.format(INPUT_IN, 1)).getValue());

            getInputs().values().stream()
                    .map(in ->
                        {
                            try {

                                setOutputValue(OUTPUT_OUT, getOutput(OUTPUT_OUT).and(in));

                                return true;
                            } catch (NonSupportedOperationException e) {

                                setOutputValue(OUTPUT_OUT, false);

                                return false;
                            }
                        })
                    .collect(Collectors.toList());
        }

        return getOutputs();
    }
}