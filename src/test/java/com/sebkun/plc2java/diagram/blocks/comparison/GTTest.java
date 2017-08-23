package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import com.sebkun.plc2java.diagram.connector.types.INT;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class GTTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testGT_0()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testGT_1()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 1);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testGT_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 0);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);
        inputMap.put(String.format(GT.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testGT_3()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 1);
        Connector in2 = new INT(0, 0);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);
        inputMap.put(String.format(GT.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testGT_4()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 1);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);
        inputMap.put(String.format(GT.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testGT_5()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 0);
        Connector in3 = new INT(0, 0);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);
        inputMap.put(String.format(GT.INPUT_IN, 2), in2);
        inputMap.put(String.format(GT.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testGT_6()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 1);
        Connector in3 = new INT(0, 1);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);
        inputMap.put(String.format(GT.INPUT_IN, 2), in2);
        inputMap.put(String.format(GT.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testGT_7()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 1);
        Connector in3 = new INT(0, 2);

        inputMap.put(String.format(GT.INPUT_IN, 1), in1);
        inputMap.put(String.format(GT.INPUT_IN, 2), in2);
        inputMap.put(String.format(GT.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(GT.OUTPUT_OUT, out);

        GT block = new GT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(GT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(GT.OUTPUT_OUT), equalTo(false));
    }
}