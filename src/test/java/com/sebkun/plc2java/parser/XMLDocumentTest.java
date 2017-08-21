package com.sebkun.plc2java.parser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author sebkun
 */
public class XMLDocumentTest {

    // TODO: Implement Data Provider for resource files!

    @Test
    public void testParseDocument_0() {

        String path = "src/test/java/resources/examples/example01.xml";

        XMLDocument doc = new XMLDocument(path);

        assertThat("Definitions of XMLDocument are null!", doc.getDefinitions(), notNullValue());
        assertThat("Definitions of XMLDocument are empty!", doc.getDefinitions().isEmpty(), equalTo(false));

        assertThat("Variables of XMLDocument are null!", doc.getVariables(), notNullValue());
        assertThat("Variables of XMLDocument are empty!", doc.getVariables().isEmpty(), equalTo(false));

        assertThat("Functions of XMLDocument are null!", doc.getFunctions(), notNullValue());
        assertThat("Functions of XMLDocument are empty!", doc.getFunctions().isEmpty(), equalTo(false));
    }

    @Test
    public void testParseDocument_1() {

        String path = "src/test/java/resources/examples/example02.xml";

        XMLDocument doc = new XMLDocument(path);

        assertThat("Definitions of XMLDocument are null!", doc.getDefinitions(), notNullValue());
        assertThat("Definitions of XMLDocument are empty!", doc.getDefinitions().isEmpty(), equalTo(false));

        assertThat("Variables of XMLDocument are null!", doc.getVariables(), notNullValue());
        assertThat("Variables of XMLDocument are empty!", doc.getVariables().isEmpty(), equalTo(false));

        assertThat("Functions of XMLDocument are null!", doc.getFunctions(), notNullValue());
        assertThat("Functions of XMLDocument are empty!", doc.getFunctions().isEmpty(), equalTo(false));
    }

}