package com.sebkun.plc2java.diagram.connector;

import com.sebkun.plc2java.diagram.connector.operators.comparison;
import com.sebkun.plc2java.diagram.connector.operators.bitwise;

/**
 * @author sebkun
 */
public abstract class Connector<T> implements comparison, bitwise {

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

