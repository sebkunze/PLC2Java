package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
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
public class NOTTest {

    Map<String, Connector> inputMap, outputMap;

    @Before
    public void setUp() {

        inputMap  = new HashMap<>();
        outputMap = new HashMap<>();
    }

    @Test
    public void testNOT_0()
            throws NonSupportedOperationException {

        Connector in  = new BOOL(0,true);

        inputMap.put(NOT.INPUT_IN, in);

        Connector out = new BOOL(0,true);

        outputMap.put(NOT.OUTPUT_OUT, out);

        NOT block = new NOT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(NOT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(NOT.OUTPUT_OUT), equalTo(false));
    }

    @Test
    public void testNOT_1()
            throws NonSupportedOperationException {

        Connector in  = new BOOL(0,false);

        inputMap.put(NOT.INPUT_IN, in);

        Connector out = new BOOL(0,false);

        outputMap.put(NOT.OUTPUT_OUT, out);

        NOT block = new NOT(0, 0, inputMap, outputMap);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(NOT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(NOT.OUTPUT_OUT), equalTo(true));
    }
}