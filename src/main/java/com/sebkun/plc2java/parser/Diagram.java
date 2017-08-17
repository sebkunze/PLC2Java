package com.sebkun.plc2java.parser;

import com.sebkun.plc2java.parser.objects.Function;
import com.sebkun.plc2java.parser.objects.Variable;

import java.util.List;

/**
 * @author sebkun
 */
public class Diagram {

    private List<Function> functions;

    private List<Variable> variables;

    public Diagram(List<Function> functions, List<Variable> variables) {
        this.functions = functions;
        this.variables = variables;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }
}