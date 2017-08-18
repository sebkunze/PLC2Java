package com.sebkun.plc2java.diagram.connector;

import com.sebkun.plc2java.diagram.connector.operators.COMPARISON;
import com.sebkun.plc2java.diagram.connector.operators.LOGIC;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;
import com.sebkun.plc2java.diagram.connector.types.BOOL;

/**
 * @author sebkun
 */
public abstract class Connector<T> implements COMPARISON, LOGIC {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Connector eq(Connector c)
            throws NonSupportedOperationException {

        return new BOOL(this.getValue() == c.getValue());
    }

    @Override
    public Connector ne(Connector c)
            throws NonSupportedOperationException {

        return new BOOL(this.getValue() != c.getValue());
    }
}

