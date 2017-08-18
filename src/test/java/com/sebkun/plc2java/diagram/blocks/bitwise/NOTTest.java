package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class NOTTest {

    @Test
    public void testNOT_0() {

        Connector in  = new BOOL(true);
        Connector out = new BOOL(true);

        NOT block = new NOT(0, in, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(NOT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(NOT.OUTPUT_OUT).getValue(), equalTo(false));
    }

    @Test
    public void testNOT_1() {

        Connector in  = new BOOL(false);
        Connector out = new BOOL(false);

        NOT block = new NOT(0, in, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(NOT.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(NOT.OUTPUT_OUT).getValue(), equalTo(true));
    }
}