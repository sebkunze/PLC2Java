package com.sebkun.plc2java.parser.handler;

import com.sebkun.plc2java.parser.objects.XMLDefinition;
import com.sebkun.plc2java.parser.objects.XMLFunction;
import com.sebkun.plc2java.parser.objects.definitions.XMLVariableDefinition;
import com.sebkun.plc2java.parser.objects.functions.XMLBlock;
import com.sebkun.plc2java.parser.objects.variables.XMLInOutVariable;
import com.sebkun.plc2java.parser.objects.variables.XMLInVariable;
import com.sebkun.plc2java.parser.objects.variables.XMLOutVariable;
import com.sebkun.plc2java.parser.objects.XMLVariable;
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

    private static final String ELEMENT_IN_VARIABLE     = "inVariable";

    private static final String ELEMENT_IN_OUT_VARIABLE = "inOutVariable";

    private static final String ELEMENT_OUT_VARIABLE    = "outVariable";

    private static final String ELEMENT_CONNECTION      = "connection";

    private static final String ELEMENT_BLOCK           = "block";

    private static final String ELEMENT_INPUT_VARIABLE  = "inputVariable";

    private static final String ELEMENT_INOUT_VARIABLE = "inOutVariable";

    private static final String ELEMENT_OUTPUT_VARIABLE = "outputVariable";

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

    private List<XMLDefinition> definitions = new ArrayList<>();

    private List<XMLVariable>   variables   = new ArrayList<>();

    private List<XMLFunction>   functions   = new ArrayList<>();

    /**
     * --- STACK ELEMENTS FOR PARSING ---
     */

    private Stack<String> elmStack = new Stack<>();

    private Stack<Object> objStack = new Stack<>();

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

        // <localVars>
        //   <variable name="?"..>
        // </localVars>
        if (ELEMENT_VARIABLE.equals(qName) && currentElementParent().equals(ELEMENT_LOCAL_VARS)) {

            XMLVariableDefinition def = new XMLVariableDefinition(
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NAME))));

            this.objStack.push(def);

            definitions.add(def);

        // <localVars>
        //   <variable>
        //     <type>
        //       <BOOL /> or <INT />
        //     </type>
        //   </variable>
        // </localVars>
        } else if ((ELEMENT_BOOL.equals(qName) || ELEMENT_INT.equals(qName)) && currentElementParent().equals(ELEMENT_TYPE)) {

            XMLDefinition def = (XMLDefinition) this.objStack.peek();

            def.setType(qName);

        // <localVars>
        //   <variable>
        //     <initialValue>
        //       <simpleValue..>
        //     </initialValue>
        //   </variable>
        // </localVars>
        } else if (ELEMENT_SIMPLE_VALUE.equals(qName) && currentElementParent().equals(ELEMENT_INITIAL_VALUE)) {

            XMLDefinition def = (XMLDefinition) this.objStack.peek();

            def.setInitialValue(
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_VALUE))));

        // <FBD>
        //   <inVariable localId="?' executionOrderId="?" negated="?"..>
        // </FBD>
        } else if (ELEMENT_IN_VARIABLE.equals(qName)) {

            XMLInVariable var = new XMLInVariable(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED))));

            if (!this.variables.contains(var)) {
                variables.add(var);
            }

            this.objStack.push(var);

        // <FBD>
        //   <inOutVariable localId="?' executionOrderId="?" negated="?"..>
        // </FBD>
        } else if (ELEMENT_IN_OUT_VARIABLE.equals(qName)) {

            XMLInOutVariable var = new XMLInOutVariable(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED_IN))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED_OUT))));

            if (!this.variables.contains(var)) {
                variables.add(var);
            }

            this.objStack.push(var);

        // <FBD>
        //   <outVariable localId="?' executionOrderId="?" negated="?"..>
        // </FBD>
        } else if (ELEMENT_OUT_VARIABLE.equals(qName)) {

            XMLOutVariable var = new XMLOutVariable(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))),
                    Boolean.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_NEGATED))));

            if (!variables.contains(var)) {
                variables.add(var);
            }

            this.objStack.push(var);

        // <FBD>
        //   <block localId="?" typeName="?" executionOrderId="?"..>
        // </FBD>
        } else if (ELEMENT_BLOCK.equals(qName)) {

            XMLBlock block = new XMLBlock(
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_LOCAL_ID))),
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_TYPE_NAME))),
                    Integer.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_EXECUTION_ORDER_ID))));

            this.objStack.push(block);

            functions.add(block);

        // <FBD>
        //   <block>
        //    <inputVariables>  or <inOutVariables>  or <outputVariables>
        //      <variable formalParam="?"..>
        //    </inputVariables> or </inOutVariables> or </outputVariables>
        //   </block>
        // </FBD>
        } else if (ELEMENT_VARIABLE.equals(qName) && containsElement(ELEMENT_BLOCK)) {

            this.objStack.push(
                    String.valueOf(attributes.getValue(attributes.getIndex(ATTRIBUTE_FORMAL_PARAMETER))));

        // <FBD>
        //   <inputVariable>
        //     <variable>
        //       <connectionPointIn>
        //         <connection refLocalId="?"..>
        //       </connectionPointIn>
        //     </variable>
        //   </inputVariable>
        // </FBD>
        } else if (ELEMENT_CONNECTION.equals(qName) && containsElement(ELEMENT_INPUT_VARIABLE)) {

            // pop formal parameter attribute of variable element
            String param = String.valueOf(this.objStack.pop());

            // peek at function block
            XMLBlock block = (XMLBlock) this.objStack.peek();

            block.setInputVariable(
                    param, Integer.valueOf(attributes.getValue(attributes.getIndex(XMLBlock.ATTRIBUTE_REF_LOCAL_ID))));

            this.objStack.push(param);

        // <FBD>
        //   <inOutVariable>
        //     <variable>
        //       <connectionPointIn>
        //         <connection refLocalId="?"..>
        //       </connectionPointIn>
        //     </variable>
        //   </inOutVariable>
        // </FBD>
        } else if (ELEMENT_CONNECTION.equals(qName) && containsElement(ELEMENT_INOUT_VARIABLE)) {

            // pop formal parameter attribute of variable element
            String param = String.valueOf(this.objStack.pop());

            // peek at function block
            XMLBlock block = (XMLBlock) this.objStack.peek();

            block.setInOutVariable(
                    param, Integer.valueOf(attributes.getValue(attributes.getIndex(XMLBlock.ATTRIBUTE_REF_LOCAL_ID))));

            this.objStack.push(param);

        // <FBD>
        //   <outputVariable>
        //     <variable>
        //       <connectionPointIn>
        //         <connection refLocalId="?"..>
        //       </connectionPointIn>
        //     </variable>
        //   </outputVariable>
        // </FBD>
        } else if (ELEMENT_CONNECTION.equals(qName) && containsElement(ELEMENT_OUTPUT_VARIABLE)) {

            // pop formal parameter attribute of variable element
            String param = String.valueOf(objStack.pop());

            // peek at function block
            XMLBlock block = (XMLBlock) objStack.peek();

            block.setOutputVariable(
                    param, Integer.valueOf(attributes.getValue(attributes.getIndex(XMLBlock.ATTRIBUTE_REF_LOCAL_ID))));

            this.objStack.push(param);
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

            XMLVariable var = (XMLVariable) this.objStack.peek();

            var.setExpression(value);
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        super.ignorableWhitespace(ch, start, length);
    }

    /**
     * Returns the element's name of the currently traversed branch of the
     * xml document; otherwise returns an empty string.
     *
     * @return element's name
     */
    private String currentElement() {

        if (elmStack.isEmpty()) {
            return "";
        }

        return elmStack.peek();
    }

    /**
     * Return the parent element's name of the currently traversed branch of
     * the xml document; otherwise returns an empty string.
     *
     * @return parent element's name
     */
    private String currentElementParent() {

        if(elmStack.isEmpty() || elmStack.size() < 2) {
            return "";
        }

        return elmStack.get(elmStack.size() - 2);
    }

    /**
     * Returns {@code true} if the currently traversed branch of the xml
     * document contains the given element; otherwise returns {@code false}.
     *
     * @param elm element of the traversed document to be tested
     * @return {@code true} if the traversed branch contains the specified element
     */
    private boolean containsElement(String elm) {

        return elmStack.contains(elm);
    }

    public List<XMLDefinition> getDefinitions() {

        return definitions;
    }

    public List<XMLVariable> getVariables() {

        return variables;
    }

    public List<XMLFunction> getFunctions() {

        return functions;
    }
}