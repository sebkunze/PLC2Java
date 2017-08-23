package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import com.sebkun.plc2java.diagram.connector.types.INT;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class NETest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testNE_0()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 0);

        inputMap.put(String.format(GE.INPUT_IN, 1), in1);
        inputMap.put(String.format(GE.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(NE.OUTPUT_OUT, out);

        NE block = new NE(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(NE.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(NE.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testNE_1()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 1);
        Connector in2 = new INT(0, 0);

        inputMap.put(String.format(GE.INPUT_IN, 1), in1);
        inputMap.put(String.format(GE.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(NE.OUTPUT_OUT, out);

        NE block = new NE(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(NE.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(NE.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testNE_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 1);

        inputMap.put(String.format(GE.INPUT_IN, 1), in1);
        inputMap.put(String.format(GE.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(NE.OUTPUT_OUT, out);

        NE block = new NE(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(NE.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(NE.OUTPUT_OUT), equalTo(true));
    }
}
