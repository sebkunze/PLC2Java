package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class ORTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testOR_0()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, true);

        inputMap.put(String.format(OR.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, false);

        outputMap.put(OR.OUTPUT_OUT, out);

        OR block = new OR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(OR.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testOR_1()
            throws NonSupportedOperationException  {

        Connector in1 = new BOOL(0, false);

        inputMap.put(String.format(OR.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, false);

        outputMap.put(OR.OUTPUT_OUT, out);

        OR block = new OR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(OR.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testOR_2()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0,true);
        Connector in2 = new BOOL(0,true);

        inputMap.put(String.format(OR.INPUT_IN, 1), in1);
        inputMap.put(String.format(OR.INPUT_IN, 2), in2);

        Connector out = new BOOL(0,false);

        outputMap.put(OR.OUTPUT_OUT, out);

        OR block = new OR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(OR.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testOR_3()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, true);
        Connector in2 = new BOOL(0, true);
        Connector in3 = new BOOL(0, true);

        inputMap.put(String.format(OR.INPUT_IN, 1), in1);
        inputMap.put(String.format(OR.INPUT_IN, 2), in2);
        inputMap.put(String.format(OR.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(OR.OUTPUT_OUT, out);

        OR block = new OR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(OR.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testOR_4()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, false);
        Connector in2 = new BOOL(0, false);
        Connector in3 = new BOOL(0, false);

        inputMap.put(String.format(OR.INPUT_IN, 1), in1);
        inputMap.put(String.format(OR.INPUT_IN, 2), in2);
        inputMap.put(String.format(OR.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, true);

        outputMap.put(OR.OUTPUT_OUT, out);

        OR block = new OR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(OR.OUTPUT_OUT), equalTo(false));
    }
}