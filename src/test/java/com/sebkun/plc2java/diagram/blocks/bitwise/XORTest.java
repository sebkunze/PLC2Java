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
public class XORTest {

    @Test
    public void testXOR_0()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(false);

        XOR block = new XOR(0, 0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testXOR_1()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(false);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(true);

        XOR block = new XOR(0, 0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testXOR_2()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        XOR block = new XOR(0, 0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(false));
    }

    @Test
    public void testXOR_3()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(true);
        Connector in3 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(false);

        XOR block = new XOR(0, 0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testXOR_4()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(false);
        Connector in3 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(false);

        XOR block = new XOR(0, 0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(XOR.OUTPUT_OUT), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(false));
    }
}