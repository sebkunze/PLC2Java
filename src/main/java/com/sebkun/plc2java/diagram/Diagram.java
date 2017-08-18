package com.sebkun.plc2java.diagram;

import com.sebkun.plc2java.diagram.blocks.FunctionBlock;
import com.sebkun.plc2java.parser.XMLDocument;
import com.sebkun.plc2java.parser.objects.XMLFunction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author sebkun
 */
public class Diagram {

    private List<FunctionBlock> blocks;

    public Diagram(XMLDocument document) {

        this.initialiseBlocks(document);
    }

    private void initialiseBlocks(XMLDocument document) {

        for (XMLFunction func : document.getFunctions()) {

            for (Map.Entry<String, Integer> e : func.getInputVariables().entrySet()) {
                String  key     = e.getKey();
                Integer localID = e.getValue();


            }

        }

        blocks.sort(Comparator.comparing(FunctionBlock::getExecutionOrderId));
    }

    public void execute() {



    }
}