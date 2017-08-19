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
public class GETest {

    @Test
    public void testGE_0()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(false);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testGE_1()
            throws NonSupportedOperationException {

        Connector in1 = new INT(1);

        List<Connector> ins = Arrays.asList(in1);

        Connector out = new BOOL(false);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testGE_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(0);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testGE_3()
            throws NonSupportedOperationException {

        Connector in1 = new INT(1);
        Connector in2 = new INT(0);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                block.getOutput().getValue(), equalTo(true));
    }

    @Test
    public void testGE_4()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(1);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(false));
    }

    @Test
    public void testGE_5()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(0);
        Connector in3 = new INT(0);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(true);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testGE_6()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(1);
        Connector in3 = new INT(1);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(false);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(false));
    }

    @Test
    public void testGE_7()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(1);
        Connector in3 = new INT(2);

        List<Connector> ins = Arrays.asList(in1, in2, in3);

        Connector out = new BOOL(false);

        GE block = new GE(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(false));
    }
}