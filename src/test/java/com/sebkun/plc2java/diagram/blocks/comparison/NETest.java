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
public class NETest {

    @Test
    public void testNE_0()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(0);

        Connector out = new BOOL(false);

        NE block = new NE(0, 0, in1, in2, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(false));
    }

    @Test
    public void testNE_1()
            throws NonSupportedOperationException {

        Connector in1 = new INT(1);
        Connector in2 = new INT(0);

        Connector out = new BOOL(false);

        NE block = new NE(0, 0, in1, in2, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }

    @Test
    public void testNE_2()
            throws NonSupportedOperationException {

        Connector in1 = new INT(0);
        Connector in2 = new INT(1);

        Connector out = new BOOL(false);

        NE block = new NE(0, 0, in1, in2, out);

        block.execute();

        assertThat("block does not update output connector.",
                 block.getOutput(), equalTo(out));

        assertThat("block does not perform operation correctly.",
                 block.getOutputValue(), equalTo(true));
    }
}
