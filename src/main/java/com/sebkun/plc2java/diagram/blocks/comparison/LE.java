package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public class LE extends FunctionBlock {

    // --- INPUTS --

    // --- OUTPUTS ---

    public static final String OUTPUT_OUT          = "OUT";

    // --- PATTERNS ---

    private static final String INPUT_IN_PATTERN = "IN";

    public LE(int executionOrderId, List<Connector> inputList) {
        super(executionOrderId);

        this.setInputList(INPUT_IN_PATTERN, inputList);
    }

    @Override
    public Map<String, Connector> execute() {
        return null;
    }
}