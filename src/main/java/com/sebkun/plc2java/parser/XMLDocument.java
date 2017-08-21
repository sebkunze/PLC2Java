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

    private List<XMLFunction>   functions;

    private List<XMLVariable>   variables;

    private List<XMLDefinition> definitions;

    public XMLDocument(String path) {

        try {

            InputStream stream = new FileInputStream(path);

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();

            parser.parse(stream, handler);

            definitions = handler.getDefinitions();
            variables   = handler.getVariables();
            functions   = handler.getFunctions();

        } catch (Exception e) {

            e.printStackTrace();

            definitions = new ArrayList<>();
            variables   = new ArrayList<>();
            functions   = new ArrayList<>();
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