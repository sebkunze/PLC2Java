package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.connector.Connector;

import java.util.Map;

/**
 * @author sebkun
 */
public class NE extends FunctionBlock {

    public static final String INPUT_IN1  = "IN1";

    public static final String INPUT_IN2  = "IN2";

    public static final String OUTPUT_OUT = "OUT";

    public NE(int executionOrderId) {
        super(executionOrderId);


    }

    @Override
    public Map<String, Connector> execute() {
        return null;
    }
}