package com.sebkun.plc2java.diagram.blocks.arithmetic;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
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
public class MULTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testMUL_0()
            throws NonSupportedOperationException {

        Connector<Integer> in1 = new INT(0, 0);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);

        Connector<Integer> out = new INT(0, 0);

        outputMap.put(String.format(MUL.OUTPUT_OUT), out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MUL.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MUL.OUTPUT_OUT), equalTo(0));
    }

    @Test
    public void testMUL_1()
            throws NonSupportedOperationException {

        Connector<Integer> in1 = new INT(0, 1);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);

        Connector<Integer> out = new INT(0, 0);

        outputMap.put(String.format(MUL.OUTPUT_OUT), out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MUL.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MUL.OUTPUT_OUT), equalTo(1));
    }

    @Test
    public void testMUL_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0,1);
        Connector in2 = new INT(0,2);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);
        inputMap.put(String.format(MUL.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MUL.OUTPUT_OUT, out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MUL.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MUL.OUTPUT_OUT), equalTo(2));
    }

    @Test
    public void testMUL_3()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0,-1);
        Connector in2 = new INT(0,2);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);
        inputMap.put(String.format(MUL.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MUL.OUTPUT_OUT, out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MUL.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MUL.OUTPUT_OUT), equalTo(-2));
    }

    @Test
    public void testMUL_4()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0,1);
        Connector in2 = new INT(0,-2);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);
        inputMap.put(String.format(MUL.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MUL.OUTPUT_OUT, out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MUL.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MUL.OUTPUT_OUT), equalTo(-2));
    }

    @Test
    public void testMUL_5()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0,-1);
        Connector in2 = new INT(0,-2);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);
        inputMap.put(String.format(MUL.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MUL.OUTPUT_OUT, out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(MUL.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputValue(MUL.OUTPUT_OUT), equalTo(2));
    }

    @Test
    public void testMUL_6()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, false);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);

        Connector out = new INT(0, 0);

        outputMap.put(MUL.OUTPUT_OUT, out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        try {

            block.execute();

            fail("block does not perform operation correctly.");

        } catch (NonSupportedOperationException e) {

            // test successful
        }
    }

    @Test
    public void testMUL_7()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(0, false);
        Connector in2 = new INT(0, 0);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);
        inputMap.put(String.format(MUL.INPUT_IN, 2), in2);

        Connector out = new INT(0, 0);

        outputMap.put(MUL.OUTPUT_OUT, out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        try {

            block.execute();

            fail("block does not perform operation correctly.");

        } catch (NonSupportedOperationException e) {

            // test successful
        }
    }

    @Test
    public void testMUL_8()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0, 0);

        inputMap.put(String.format(MUL.INPUT_IN, 1), in1);

        Connector out = new BOOL(0, false);

        outputMap.put(MUL.OUTPUT_OUT, out);

        MUL block = new MUL(0, 0, inputMap, outputMap);

        try {

            block.execute();

            fail("block does not perform operation correctly.");

        } catch (NonSupportedOperationException e) {

            // test successful
        }
    }
}