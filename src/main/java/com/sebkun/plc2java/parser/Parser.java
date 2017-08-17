package com.sebkun.plc2java.parser;

import com.sebkun.plc2java.parser.handler.SAXHandler;
import com.sebkun.plc2java.parser.objects.Function;
import com.sebkun.plc2java.parser.objects.Variable;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sebkun
 */
public class Parser {

    public Diagram parse(String path) {

        List<Function> functions;
        List<Variable> variables;

        try {

            InputStream stream = new FileInputStream(path);

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();

            parser.parse(stream, handler);

            functions = handler.getFunctions();
            variables = handler.getVariables();

        } catch (Exception e) {

            e.printStackTrace();

            functions = new ArrayList<Function>();
            variables = new ArrayList<Variable>();

        }

        return new Diagram(functions, variables);
    }

}