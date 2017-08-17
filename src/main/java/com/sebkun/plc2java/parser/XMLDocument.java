package com.sebkun.plc2java.parser;

import com.sebkun.plc2java.parser.handler.SAXHandler;
import com.sebkun.plc2java.parser.objects.XMLDefinition;
import com.sebkun.plc2java.parser.objects.XMLFunction;
import com.sebkun.plc2java.parser.objects.XMLVariable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sebkun
 */
public class XMLDocument {

    List<XMLFunction>   functions;

    List<XMLVariable>   variables;

    List<XMLDefinition> definitions;

    public XMLDocument(String path) {

        try {

            InputStream stream = new FileInputStream(path);

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();

            parser.parse(stream, handler);

            functions  = handler.getFunctions();
            variables  = handler.getVariables();
            definitions = handler.getDefinitions();

        } catch (Exception e) {

            e.printStackTrace();

            functions  = new ArrayList<XMLFunction>();
            variables  = new ArrayList<XMLVariable>();
            definitions = new ArrayList<XMLDefinition>();
        }
    }

    public List<XMLFunction> getFunctions() {
        return functions;
    }

    public List<XMLVariable> getVariables() {
        return variables;
    }

    public List<XMLDefinition> getDefinitions() {
        return definitions;
    }
}