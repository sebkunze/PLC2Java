package com.sebkun.plc2java.diagram.blocks.comparison;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import com.sebkun.plc2java.diagram.connector.types.INT;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class EQTest {

    @Test
    public void testEQ_0()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(false);

        EQ block = new EQ(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(EQ.OUTPUT_OUT).getValue(), equalTo(true));
    }

    @Test
    public void testEQ_1()
            throws NonSupportedOperationException {

        Connector in1 = new INT(1);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(false);

        EQ block = new EQ(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(EQ.OUTPUT_OUT).getValue(), equalTo(true));
    }

    @Test
    public void testEQ_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(1);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(true);

        EQ block = new EQ(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(EQ.OUTPUT_OUT).getValue(), equalTo(false));
    }

    @Test
    public void testEQ_3()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(0);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        EQ block = new EQ(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(EQ.OUTPUT_OUT).getValue(), equalTo(true));
    }

    @Test
    public void testEQ_4()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(1);
        Connector in3 = new INT(0);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(true);

        EQ block = new EQ(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(EQ.OUTPUT_OUT).getValue(), equalTo(false));
    }

    @Test
    public void testEQ_5()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(0);
        Connector in3 = new INT(0);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(false);

        EQ block = new EQ(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(EQ.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutputs().get(EQ.OUTPUT_OUT).getValue(), equalTo(true));
    }
}