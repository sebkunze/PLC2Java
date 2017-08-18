package com.sebkun.plc2java.diagram.connector;

import com.sebkun.plc2java.diagram.connector.operators.COMPARISON;
import com.sebkun.plc2java.diagram.connector.operators.LOGIC;

/**
 * @author sebkun
 */
public abstract class Connector implements COMPARISON, LOGIC {

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

