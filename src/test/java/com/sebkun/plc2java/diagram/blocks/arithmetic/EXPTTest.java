package com.sebkun.plc2java.diagram.blocks.arithmetic;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.INT;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class EXPTTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testEXPT_0()
            throws NonSupportedOperationException {

        Connector<Integer> in1 = new INT(0, 0);

        inputMap.put(String.format(EXPT.INPUT_IN, 1), in1);

        Connector<Integer> out = new INT(0, 0);

        outputMap.put(String.format(EXPT.OUTPUT_OUT), out);

        EXPT block = new EXPT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EXPT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(EXPT.OUTPUT_OUT), equalTo(0));
    }

    @Test
    public void testEXPT_1()
            throws NonSupportedOperationException {

        Connector<Integer> in1 = new INT(0, 1);

        inputMap.put(String.format(EXPT.INPUT_IN, 1), in1);

        Connector<Integer> out = new INT(0, 0);

        outputMap.put(String.format(EXPT.OUTPUT_OUT), out);

        EXPT block = new EXPT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EXPT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(EXPT.OUTPUT_OUT), equalTo(1));
    }
}