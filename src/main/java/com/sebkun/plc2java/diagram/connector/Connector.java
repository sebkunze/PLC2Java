package com.sebkun.plc2java.diagram.connector;

import com.sebkun.plc2java.diagram.connector.operators.COMPARISON;
import com.sebkun.plc2java.diagram.connector.operators.LOGIC;

/**
 * @author sebkun
 */
public abstract class Connector<T> implements COMPARISON, LOGIC {

    protected int localId;

    protected T value;

    public T getValue() {
        return value;
    }

    public Connector (int localId, T value) {
        this.localId = localId;
        this.value   = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

