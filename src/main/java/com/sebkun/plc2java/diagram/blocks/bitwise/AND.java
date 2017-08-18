package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.LOGIC;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

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

    @Override
    public Map<String, Connector> execute() {

        this.updateOutput(
                OR.OUTPUT_OUT,
                inputs.values().stream().reduce(outputs.get(OUTPUT_OUT), (x, y) -> x.and(y)));

        return outputs;
    }
}