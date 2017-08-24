package com.sebkun.plc2java.parser.objects.tree;

/**
 * @author sebkun
 */
public abstract class XMLDefinition {

    private String name;

    private String type;

    private String initialValue;

    public XMLDefinition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }
}