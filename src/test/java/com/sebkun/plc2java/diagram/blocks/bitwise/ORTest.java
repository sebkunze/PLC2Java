package com.sebkun.plc2java.diagram.blocks.bitwise;


import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author sebkun
 */
public class ANDTest {


    @Test
    public void testAND_0() {

        Connector in1 = new BOOL(false);
        Connector in2 = new BOOL(false);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        AND and = new AND(0, ins, out);

        and.execute();

        assertThat(out.getValue(), equalTo(false));
    }

    @Test
    public void testAND_1() {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(false);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        AND and = new AND(0, ins, out);

        and.execute();

        assertThat(out.getValue(), equalTo(false));
    }

    @Test
    public void testAND_2() {

        Connector in1 = new BOOL(false);
        Connector in2 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        AND and = new AND(0, ins, out);

        and.execute();

        assertThat(out.getValue(), equalTo(false));
    }

    @Test
    public void testAND_3() {

        Connector in1 = new BOOL(true);
        Connector in2 = new BOOL(true);

        List<Connector> ins = Arrays.asList(in1, in2);

        Connector out = new BOOL(false);

        AND and = new AND(0, ins, out);

        and.execute();

        assertThat(out.getValue(), equalTo(true));
    }

}