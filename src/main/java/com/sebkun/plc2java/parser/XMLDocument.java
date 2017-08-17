package com.sebkun.plc2java.parser;

import com.sebkun.plc2java.diagram.Diagram;
import com.sebkun.plc2java.parser.handler.SAXHandler;
import com.sebkun.plc2java.parser.objects.Definition;
import com.sebkun.plc2java.parser.objects.Function;
import com.sebkun.plc2java.parser.objects.Variable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sebkun
 */
public class Document {

    List<Function>   functions;

    List<Variable>   variables;

    List<Definition> definitions;

    public Document(String path) {

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

            functions  = new ArrayList<Function>();
            variables  = new ArrayList<Variable>();
            definitions = new ArrayList<Definition>();
        }
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}