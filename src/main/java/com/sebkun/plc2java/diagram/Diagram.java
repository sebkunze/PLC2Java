package com.sebkun.plc2java.diagram;

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

import java.util.*;

/**
 * @author sebkun
 */
public class Diagram {

    //

    private XMLDocument document;

    //

    private List<FunctionBlock> funcs;

    public Diagram(XMLDocument document) {

        this.document = document;

        this.parse();
    }

    public List<FunctionBlock> parse() {

        List<FunctionBlock> funcs = new ArrayList<>();

        try {

            document.getFunctions().sort(Comparator.comparing(XMLFunction::getExecutionOrderID));

            for (XMLFunction function : document.getFunctions()) {

                funcs.add(parseFunction(function));
            }

        } catch (NonSupportedOperationException e) {

            e.printStackTrace();

            funcs = Collections.EMPTY_LIST;
        }

        return funcs;
    }

    private FunctionBlock parseFunction(XMLFunction function)
            throws NonSupportedOperationException {

        FunctionBlock block
                = lookupBlock(function);

        Map<String, Connector> inputMap
                = getInputConnectors(function);

        block.setInputs(inputMap);

        Map<String, Connector> outputMap
                = getOutputConnectors(function);

        block.setOutputs(outputMap);

        return block;
    }

    private FunctionBlock lookupBlock(XMLFunction function)
            throws NonSupportedOperationException {

        Integer localId
                = function.getLocalId();

        Integer executionOrderId
                = function.getExecutionOrderID();

        switch (Block.valueOf(function.getTypeName())) {

            case AND:
                return new AND(localId, executionOrderId);

            case NOT:
                return new NOT(localId, executionOrderId);

            case OR:
                return new OR(localId, executionOrderId);

            case XOR:
                return new XOR(localId, executionOrderId);

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
                throw new NonSupportedOperationException("");
        }
    }

    private Map<String, Connector> getInputConnectors(XMLFunction function)
            throws NonSupportedOperationException {

        Map<String, Connector> inputs = new HashMap<>();

        for (Map.Entry<String, Integer> e : function.getInputVariables().entrySet()) {

            String  key        = e.getKey();
            Integer localRefId = e.getValue();

            Connector in = lookupInputVariable(localRefId, function.getTypeName());

            inputs.put(key, in);
        }

        return inputs;
    }

    private Map<Integer, Connector> inputVariableCache = new HashMap<>();

    private Connector lookupInputVariable(Integer localRefId, String typeName)
            throws NonSupportedOperationException {

        Connector in = inputVariableCache.get(localRefId);

        // create Connector if inputVariableCache does not contain it.
        if (in == null) {

            if(Block.isArithmeticFunctionBlock(typeName)) {

                throw new NonSupportedOperationException("");

            } else if (Block.isBitShiftFunctionBlock(typeName)) {

                throw new NonSupportedOperationException("");

            } else if (Block.isBitwiseFunctionBlock(typeName)) {

                in = new BOOL(localRefId, false); // TODO: take care of initial value

            } else if (Block.isComparisonFunctionBlock(typeName)) {

                in = new INT(localRefId, 0); // TODO: take care of initial value

            }

            inputVariableCache.put(localRefId, in);
        }

        return in;
    }

    private Map<String, Connector> getOutputConnectors(XMLFunction function)
            throws NonSupportedOperationException {

        Map<String, Connector> outputs = new HashMap<>();

        for (Map.Entry<String, Integer> e : function.getOutputVariables().entrySet()) {

            String  key        = e.getKey();
            Integer localRefId = e.getValue();

            Connector out = lookupOutputVariable(localRefId, function.getTypeName());

            outputs.put(key, out);
        }

        return outputs;
    }

    private Map<Integer, Connector> outputVariableCache = new HashMap<>();

    private Connector lookupOutputVariable(Integer localRefId, String typeName)
            throws NonSupportedOperationException {

        Connector out = outputVariableCache.get(localRefId);

        if (out == null) {

            if(Block.isArithmeticFunctionBlock(typeName)) {

                throw new NonSupportedOperationException("");

            } else if (Block.isBitShiftFunctionBlock(typeName)) {

                throw new NonSupportedOperationException("");

            } else if (Block.isBitwiseFunctionBlock(typeName)) {

                out = new BOOL(localRefId, false); // TODO: take care of initial value

            } else if (Block.isComparisonFunctionBlock(typeName)) {

                out = new BOOL(localRefId, false); // TODO: take care of initial value

            }

            outputVariableCache.put(localRefId, out);
        }

        return out;
    }

    public void execute() {

        try {
            funcs.sort(Comparator.comparing(FunctionBlock::getExecutionOrderId));

            Map<String, Connector> map = new HashMap<>();

            for (FunctionBlock func : funcs) {
                map = func.execute();
            }

            System.out.println(map.get("OUT"));

        } catch (Exception e) {

        }
    }
}