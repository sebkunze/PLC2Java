package com.sebkun.plc2java.parser;

import com.sebkun.plc2java.diagram.blocks.Block;
import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.diagram.blocks.bitwise.AND;
import com.sebkun.plc2java.diagram.blocks.bitwise.NOT;
import com.sebkun.plc2java.diagram.blocks.bitwise.OR;
import com.sebkun.plc2java.diagram.blocks.bitwise.XOR;
import com.sebkun.plc2java.diagram.blocks.comparison.*;
import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;
import com.sebkun.plc2java.diagram.connector.types.INT;
import com.sebkun.plc2java.parser.objects.XMLDocument;
import com.sebkun.plc2java.parser.objects.tree.XMLFunction;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public class XMLParser {

    private XMLDocument document;

    // TODO: Parse path from here!
    public XMLParser(XMLDocument document) {
        this.document = document;
    }

    public List<FunctionBlock> toFunctionBlocks() {

        try {

            for (XMLFunction func : document.getFunctions()) {

                toFunctionBlock(func);
            }
        } catch (NonSupportedOperationException e) {

            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param xmlFunction
     * @return
     * @throws NonSupportedOperationException
     */
    private FunctionBlock toFunctionBlock(XMLFunction xmlFunction)
            throws NonSupportedOperationException {

        // parse function block's structure
        FunctionBlock functionBlock
                = parseFunctionBlockStructure(xmlFunction);

        // parse function block's inputs
        Map<String, Connector> inputMap
                = getInputConnectors(xmlFunction);

        functionBlock.setInputs(inputMap);

        // parse function block's outputs
        Map<String, Connector> outputMap
                = getOutputConnectors(xmlFunction);

        functionBlock.setOutputs(outputMap);

        return functionBlock;
    }

    /**
     *
     * @param xmlFunction
     * @return
     * @throws NonSupportedOperationException
     */
    private FunctionBlock parseFunctionBlockStructure(XMLFunction xmlFunction)
            throws NonSupportedOperationException {

        int localId          = xmlFunction.getLocalId();
        int executionOrderId = xmlFunction.getExecutionOrderID();

        switch (Block.valueOf(xmlFunction.getTypeName())) {

            // bitwise blocks

            case AND:
                return new AND(localId, executionOrderId);

            case NOT:
                return new NOT(localId, executionOrderId);

            case OR:
                return new OR(localId, executionOrderId);

            case XOR:
                return new XOR(localId, executionOrderId);

            // comparison blocks

            case EQ:
                return new EQ(localId, executionOrderId);

            case GE:
                return new GE(localId, executionOrderId);

            case GT:
                return new GT(localId, executionOrderId);

            case LE:
                return new LE(localId, executionOrderId);

            case LT:
                return new LT(localId, executionOrderId);

            case NE:
                return new NE(localId, executionOrderId);

            default:
                throw new NonSupportedOperationException("operator's structure cannot be parsed; it has not been implemented yet!");
        }
    }

    /**
     *
     * @param function
     * @return
     * @throws NonSupportedOperationException
     */
    private Map<String, Connector> getInputConnectors(XMLFunction function)
            throws NonSupportedOperationException {

        Map<String, Connector> inputs = Collections.EMPTY_MAP;

        // arithmetic blocks require multiple INT inputs
        if (Block.isArithmeticFunctionBlock(function.getTypeName())) {

            throw new NonSupportedOperationException("operator's input cannot be parsed; it has not been implemented yet!");

        // bit shift blocks require multiple BOOL inputs
        } else if (Block.isBitShiftFunctionBlock(function.getTypeName())) {

            throw new NonSupportedOperationException("operator's input cannot be parsed; it has not been implemented yet!");

        // bitwise block require  multipleBOOL inputs
        } else if (Block.isBitwiseFunctionBlock(function.getTypeName())) {

            for (Map.Entry<String, Integer> e : function.getInputVariables().entrySet()) {

                String key      = e.getKey();
                Integer localId = e.getValue();

                Connector inputConnector = lookupBOOLConnector(localId);

                inputs.put(key, inputConnector);
            }

        // comparison block require multiple INT inputs
        } else if (Block.isComparisonFunctionBlock(function.getTypeName())) {

            for (Map.Entry<String, Integer> e : function.getInputVariables().entrySet()) {

                String key      = e.getKey();
                Integer localId = e.getValue();

                Connector inputConnector = lookupINTConnector(localId);

                inputs.put(key, inputConnector);
            }

        // standard block require multiple different inputs
        } else if (Block.isStandardFunctionBlock(function.getTypeName())) {

            throw new NonSupportedOperationException("operator's input cannot be parsed; it has not been implemented yet!");

        }

        return inputs;
    }

    /**
     *
     * @param function
     * @return
     * @throws NonSupportedOperationException
     */
    private Map<String, Connector> getOutputConnectors(XMLFunction function)
            throws NonSupportedOperationException {

        Map<String, Connector> outputs = Collections.EMPTY_MAP;

        // arithmetic blocks require one INT output
        if (Block.isArithmeticFunctionBlock(function.getTypeName())) {

            throw new NonSupportedOperationException("operator's output cannot be parsed; it has not been implemented yet!");

        // bit shift blocks require one BOOL output
        } else if (Block.isBitShiftFunctionBlock(function.getTypeName())) {

            throw new NonSupportedOperationException("operator's output cannot be parsed; it has not been implemented yet!");

        // bitwise block require one BOOL output
        } else if (Block.isBitwiseFunctionBlock(function.getTypeName())) {

            for (Map.Entry<String, Integer> e : function.getOutputVariables().entrySet()) {

                String key      = e.getKey();
                Integer localId = e.getValue();

                Connector inputConnector = lookupBOOLConnector(localId);

                outputs.put(key, inputConnector);
            }

        // comparison block require one BOOL output
        } else if (Block.isComparisonFunctionBlock(function.getTypeName())) {

            for (Map.Entry<String, Integer> e : function.getOutputVariables().entrySet()) {

                String key      = e.getKey();
                Integer localId = e.getValue();

                Connector inputConnector = lookupINTConnector(localId);

                outputs.put(key, inputConnector);
            }

        // standard block require multiple different outputs
        } else if (Block.isStandardFunctionBlock(function.getTypeName())) {

            throw new NonSupportedOperationException("operator's input cannot be parsed; it has not been implemented yet!");

        }

        return outputs;

    }

    private BOOL lookupBOOLConnector(Integer localId) {
        return null;
    }

    private INT lookupINTConnector(Integer localId) {
        return null;
    }
}