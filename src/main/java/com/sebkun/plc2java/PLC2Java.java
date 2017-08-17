package com.sebkun.plc2java;

import com.sebkun.plc2java.parser.Parser;
import com.sebkun.plc2java.parser.handler.SAXHandler;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;

public class PLC2Java {

    public static void main(String args[]) {

        String path = "src/test/resources/examples/example01.xml";

        new Parser().parse(path);

    }
}