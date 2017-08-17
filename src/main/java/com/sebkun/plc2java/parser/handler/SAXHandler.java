package com.sebkun.plc2java.parser.handler;

import com.sebkun.plc2java.parser.objects.Definition;
import com.sebkun.plc2java.parser.objects.Function;
import com.sebkun.plc2java.parser.objects.definitions.VariableDefinition;
import com.sebkun.plc2java.parser.objects.functions.Block;
import com.sebkun.plc2java.parser.objects.variables.InOutVariable;
import com.sebkun.plc2java.parser.objects.variables.InVariable;
import com.sebkun.plc2java.parser.objects.variables.OutVariable;
import com.sebkun.plc2java.parser.objects.Variable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sebkun
 */
public class SAXHandler extends DefaultHandler {

    /**
     * -- XML DOCUMENT'S ELEMENTS --
     */

    private static final String ELEMENT_LOCAL_VARS      = "localVars";

    private static final String ELEMENT_VARIABLE        = "variable";

    private static final String ELEMENT_TYPE            = "type";

    private static final String ELEMENT_INT             = "INT";

    private static final String ELEMENT_BOOL            = "BOOL";

    private static final String ELEMENT_INITIAL_VALUE   = "initialValue";

    private static final String ELEMENT_SIMPLE_VALUE    = "simpleValue";

    private static final String ELEMENT_BLOCK           = "block";

    private static final String ELEMENT_CONNECTION      = "connection";

    private static final String ELEMENT_IN_VARIABLE     = "inVariable";

    private static final String ELEMENT_IN_OUT_VARIABLE = "inOutVariable";

    private static final String ELEMENT_OUT_VARIABLE    = "outVariable";

    private static final String ELEMENT_EXPRESSION      = "expression";

    /**
     * -- XML DOCUMENT'S ATTRIBUTES --
     */

    private static final String ATTRIBUTE_NAME               = "name";

    private static final String ATTRIBUTE_VALUE              = "value";

    private static final String ATTRIBUTE_LOCAL_ID           = "localId";

    private static final String ATTRIBUTE_TYPE_NAME          = "typeName";

    private static final String ATTRIBUTE_EXECUTION_ORDER_ID = "executionOrderId";

    private static final String ATTRIBUTE_FORMAL_PARAMETER   = "formalParameter";

    private static final String ATTRIBUTE_NEGATED            = "negated";

    private static final String ATTRIBUTE_NEGATED_IN         = "negatedIn";

    private static final String ATTRIBUTE_NEGATED_OUT        = "negatedOut";

    /**
     * --- PARSED FBD PROGRAM ELEMENTS ---
     */

    private List<Function> functions     = new ArrayList<Function>();

    private List<Variable> variables     = new ArrayList<Variable>();

    private List<Definition> definitions = new ArrayList<Definition>();

    /**
     * --- STACK ELEMENTS FOR PARSING ---®
     */

    private Stack<String> elmStack   = new Stack<String>();

    private Stack<Object> objStack   = new Stack<Object>();

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        this.elmStack.push(qName);

        if (ELEMENT_BLOCK.equals(qName)) {

            Block block = new Block(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_TYPE_NAME))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))));

            this.objStack.push(block);

            functions.add(block);

        } else if (ELEMENT_VARIABLE.equals(qName) && currentElementParent().equals(ELEMENT_LOCAL_VARS)) {

            VariableDefinition var = new VariableDefinition(
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NAME))));

            this.objStack.push(var);

            definitions.add(var);

        } else if ((ELEMENT_BOOL.equals(qName) || ELEMENT_INT.equals(qName)) && currentElementParent().equals(ELEMENT_TYPE)) {

            Definition def = (Definition) this.objStack.peek();

            def.setType(qName);

        } else if (ELEMENT_SIMPLE_VALUE.equals(qName) && currentElementParent().equals(ELEMENT_INITIAL_VALUE)) {

            Definition def = (Definition) this.objStack.peek();

            def.setInitialValue(
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_VALUE))));

        } else if (ELEMENT_VARIABLE.equals(qName) && !currentElementParent().equals(ELEMENT_LOCAL_VARS)) {

            this.objStack.push(
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_FORMAL_PARAMETER))));

        } else if (ELEMENT_CONNECTION.equals(qName) && containsElement(Block.ATTRIBUTE_INPUT_VARIABLES)) {

            String param = String.valueOf(this.objStack.pop());

            Block block = (Block) this.objStack.peek();

            block.setInputVariable(
                    param, Integer.valueOf(attributes.getValue(attributes.getIndex(Block.ATTRIBUTE_REF_LOCAL_ID))));

            this.objStack.push(param);

        } else if (ELEMENT_CONNECTION.equals(qName) && containsElement(Block.ATTRIBUTE_INOUT_VARIABLES)) {

            String param = String.valueOf(this.objStack.pop());

            Block block = (Block) this.objStack.peek();

            block.setInOutVariable(
                    param, Integer.valueOf(attributes.getValue(attributes.getIndex(Block.ATTRIBUTE_REF_LOCAL_ID))));

            this.objStack.push(param);

        } else if (ELEMENT_CONNECTION.equals(qName) && containsElement(Block.ATTRIBUTE_OUTPUT_VARIABLES)) {

            String param = String.valueOf(this.objStack.pop());

            Block block = (Block) this.objStack.peek();

            block.setOutputVariable(
                    param, Integer.valueOf(attributes.getValue(attributes.getIndex(Block.ATTRIBUTE_REF_LOCAL_ID))));

            this.objStack.push(param);

        } else if (ELEMENT_IN_VARIABLE.equals(qName)) {

            InVariable var = new InVariable(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED))));

            if (!this.variables.contains(var)) {
                variables.add(var);
            }

            this.objStack.push(var);

        } else if (ELEMENT_IN_OUT_VARIABLE.equals(qName)) {

            InOutVariable var = new InOutVariable(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED_IN))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED_OUT))));

            if (!this.variables.contains(var)) {
               variables.add(var);
            }

            this.objStack.push(var);

        } else if (ELEMENT_OUT_VARIABLE.equals(qName)) {

            OutVariable var = new OutVariable(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED))));

            if (!this.variables.contains(var)) {
                variables.add(var);
            }

            this.objStack.push(var);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        this.elmStack.pop();

        if (ELEMENT_BLOCK.equals(qName)) {

            this.objStack.pop();

        } else if (ELEMENT_VARIABLE.equals(qName) && !currentElement().equals(ELEMENT_LOCAL_VARS)) {

            this.objStack.pop();

        } else if (ELEMENT_IN_VARIABLE.equals(qName)) {

            this.objStack.pop();

        } else if (ELEMENT_IN_OUT_VARIABLE.equals(qName)) {

            this.objStack.pop();

        } else if (ELEMENT_OUT_VARIABLE.equals(qName)) {

            this.objStack.pop();

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String value = new String(ch, start, length).trim();
        if(value.length() == 0) return; // ignore white space

        if (ELEMENT_EXPRESSION.equals(currentElement())) {

            Variable var = (Variable) this.objStack.peek();

            var.setExpression(value);
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        super.ignorableWhitespace(ch, start, length);
    }

    private String currentElement() {

        return this.elmStack.peek();
    }

    private String currentElementParent() {

        if(this.elmStack.size() < 2) {
            return "";
        }

        return this.elmStack.get(this.elmStack.size() - 2);
    }

    /**
     * Returns {@code true} if the currently traversed branch of the xml
     * document contains the given element; otherwise return {@code false}
     *
     * @param elm element of the traversed document to be tested
     * @return {@code true} if the traversed branch contains the specified element
     */
    private boolean containsElement(String elm) {

        return this.elmStack.contains(elm);
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