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
import static org.junit.Assert.fail;

/**
 * @author sebkun
 */
public class MODTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testMOD_0()
            throws NonSupportedOperationException {

        Connector<Integer> in1 = new INT(0, 0);

        inputMap.put(String.format(MOD.INPUT_IN, 1), in1);

        Connector<Integer> out = new INT(0, 0);

        outputMap.put(String.format(MOD.OUTPUT_OUT), out);

        MOD block = new MOD(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MOD.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MOD.OUTPUT_OUT), equalTo(0));
    }

    @Test
    public void testMOD_1()
            throws NonSupportedOperationException {

        Connector<Integer> in1 = new INT(0, 1);

        inputMap.put(String.format(MOD.INPUT_IN, 1), in1);

        Connector<Integer> out = new INT(0, 0);

        outputMap.put(String.format(MOD.OUTPUT_OUT), out);

        MOD block = new MOD(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MOD.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MOD.OUTPUT_OUT), equalTo(1));
    }

    @Test
    public void testMOD_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0,1);
        Connector in2 = new INT(0,2);

        inputMap.put(String.format(MOD.INPUT_IN, 1), in1);
        inputMap.put(String.format(MOD.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MOD.OUTPUT_OUT, out);

        MOD block = new MOD(0, 0, inputMap, outputMap);

        assertThat("block does not update output connector.",
                block.getOutput(MOD.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MOD.OUTPUT_OUT), equalTo(1));
    }

    @Test
    public void testMOD_3()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0,2);
        Connector in2 = new INT(0,1);

        inputMap.put(String.format(MOD.INPUT_IN, 1), in1);
        inputMap.put(String.format(MOD.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MOD.OUTPUT_OUT, out);

        MOD block = new MOD(0, 0, inputMap, outputMap);

        assertThat("block does not update output connector.",
                block.getOutput(MOD.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MOD.OUTPUT_OUT), equalTo(0));
    }

    @Test
    public void testMOD_4()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0,2);
        Connector in2 = new INT(0,2);

        inputMap.put(String.format(MOD.INPUT_IN, 1), in1);
        inputMap.put(String.format(MOD.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MOD.OUTPUT_OUT, out);

        MOD block = new MOD(0, 0, inputMap, outputMap);

        assertThat("block does not update output connector.",
                block.getOutput(MOD.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MOD.OUTPUT_OUT), equalTo(0));
    }
}