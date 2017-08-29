package com.sebkun.plc2java;

import com.sebkun.plc2java.parser.objects.XMLDocument;

public class PLC2Java {

    public static void main(String args[]) {

        String path = "src/test/resources/examples/example01.xml";

        new XMLDocument(path);
    }
}