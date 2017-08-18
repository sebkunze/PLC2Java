package com.sebkun.plc2java.diagram.connectors.types;

import com.sebkun.plc2java.diagram.blocks.bitwise.AND;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BOOLTest {

    @Test
    public void testBOOL_0()
            throws NonSupportedOperationException {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        AND block = new AND(0, ins, out);

        block.execute();

        assertThat("block does not update output connector.",
                block.getOutputs().get(AND.OUTPUT_OUT).getValue(), equalTo(true));
    }
}