package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.blocks.bitwise.AND;
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
public class EQTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testEQ_0()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);

        inputMap.put(String.format(EQ.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, false);

        outputMap.put(EQ.OUTPUT_OUT, out);

        EQ block = new EQ(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(EQ.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testEQ_1()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 1);

        inputMap.put(String.format(EQ.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, false);

        outputMap.put(EQ.OUTPUT_OUT, out);
        EQ block = new EQ(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(EQ.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testEQ_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 0);

        inputMap.put(String.format(EQ.INPUT_IN, 1), in1);
        inputMap.put(String.format(EQ.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(EQ.OUTPUT_OUT, out);
        EQ block = new EQ(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(EQ.OUTPUT_OUT), equalTo(true));
    }

    @Test
    public void testEQ_3()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 1);
        Connector in2 = new INT(0, 0);

        inputMap.put(String.format(EQ.INPUT_IN, 1), in1);
        inputMap.put(String.format(EQ.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(EQ.OUTPUT_OUT, out);
        EQ block = new EQ(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(EQ.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testEQ_4()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 1);

        inputMap.put(String.format(EQ.INPUT_IN, 1), in1);
        inputMap.put(String.format(EQ.INPUT_IN, 2), in2);

        Connector out = new BOOL(0, false);

        outputMap.put(EQ.OUTPUT_OUT, out);
        EQ block = new EQ(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(EQ.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testEQ_5()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 1);
        Connector in3 = new INT(0, 0);

        inputMap.put(String.format(EQ.INPUT_IN, 1), in1);
        inputMap.put(String.format(EQ.INPUT_IN, 2), in2);
        inputMap.put(String.format(EQ.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(EQ.OUTPUT_OUT, out);
        EQ block = new EQ(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(EQ.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testEQ_6()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);
        Connector in2 = new INT(0, 0);
        Connector in3 = new INT(0, 0);

        inputMap.put(String.format(EQ.INPUT_IN, 1), in1);
        inputMap.put(String.format(EQ.INPUT_IN, 2), in2);
        inputMap.put(String.format(EQ.INPUT_IN, 3), in3);

        Connector out = new BOOL(0, false);

        outputMap.put(EQ.OUTPUT_OUT, out);

        EQ block = new EQ(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(EQ.OUTPUT_OUT), equalTo(true));
    }
}