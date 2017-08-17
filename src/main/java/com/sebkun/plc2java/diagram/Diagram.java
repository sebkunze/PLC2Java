package com.sebkun.plc2java.parser;

import com.sebkun.plc2java.parser.objects.Definition;
import com.sebkun.plc2java.parser.objects.Function;
import com.sebkun.plc2java.parser.objects.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sebkun
 */
public class Diagram implements Comparable {



    public Diagram(List<Function> functions, List<Variable> variables, List<Definition> definitions) {

        this.initialiseBlocks(functions, variables, definitions);
    }

    private void initialiseBlocks(List<Function> functions, List<Variable> variables, List<Definition> defintions) {

        for (Function func : functions) {

            for (Map.Entry<String, Integer> e : func.getInputVariables().entrySet()) {
                String key      = e.getKey();
                Integer localID = e.getValue();


            }

        }


    }



    @Override
    public int compareTo(Object o) {
        return 0;
    }
}