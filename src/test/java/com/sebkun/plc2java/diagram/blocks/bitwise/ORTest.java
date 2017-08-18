package com.sebkun.plc2java.diagram.blocks.bitwise;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class ORTest {

    @Test
    public void testOR_0()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(false);

        OR block = new OR(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(OR.OUTPUT_OUT).getValue(), equalTo(true));
    }

    @Test
    public void testOR_1()
            throws NonSupportedOperationException  {

        Connector in1 = new BOOL(false);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(false);

        OR block = new OR(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(OR.OUTPUT_OUT).getValue(), equalTo(true));
    }

    @Test
    public void testOR_2()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        OR block = new OR(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(OR.OUTPUT_OUT).getValue(), equalTo(true));
    }

    @Test
    public void testOR_3()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(true);
        Connector in3 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(false);

        OR block = new OR(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(OR.OUTPUT_OUT).getValue(), equalTo(true));
    }

    @Test
    public void testOR_4()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(false);
        Connector in2 = new BOOL(false);
        Connector in3 = new BOOL(false);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(true);

        OR block = new OR(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(OR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(OR.OUTPUT_OUT).getValue(), equalTo(false));
    }
}