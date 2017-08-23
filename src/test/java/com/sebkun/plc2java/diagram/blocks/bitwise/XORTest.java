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
public class XORTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testXOR_0()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, true);

        inputMap.put(String.format(XOR.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, false);

        outputMap.put(XOR.OUTPUT_OUT, out);

        XOR block = new XOR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(XOR.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testXOR_1()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, false);

        inputMap.put(String.format(XOR.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, true);

        outputMap.put(XOR.OUTPUT_OUT, out);

        XOR block = new XOR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(XOR.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testXOR_2()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, true);
        Connector in2 = new BOOL(0, true);

        inputMap.put(String.format(XOR.INPUT_IN, 1), in1);
        inputMap.put(String.format(XOR.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(XOR.OUTPUT_OUT, out);

        XOR block = new XOR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(XOR.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testXOR_3()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, true);
        Connector in2 = new BOOL(0, true);
        Connector in3 = new BOOL(0, true);

        inputMap.put(String.format(XOR.INPUT_IN, 1), in1);
        inputMap.put(String.format(XOR.INPUT_IN, 2), in2);
        inputMap.put(String.format(XOR.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(XOR.OUTPUT_OUT, out);

        XOR block = new XOR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(XOR.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testXOR_4()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, true);
        Connector in2 = new BOOL(0, false);
        Connector in3 = new BOOL(0, true);

        inputMap.put(String.format(XOR.INPUT_IN, 1), in1);
        inputMap.put(String.format(XOR.INPUT_IN, 2), in2);
        inputMap.put(String.format(XOR.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(XOR.OUTPUT_OUT, out);

        XOR block = new XOR(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(XOR.OUTPUT_OUT), equalTo(false));
    }
}