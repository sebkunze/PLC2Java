package com.sebkun.plc2java.diagram.connector;

import com.sebkun.plc2java.diagram.connector.operators.arithmetic;
import com.sebkun.plc2java.diagram.connector.operators.bitwise;
import com.sebkun.plc2java.diagram.connector.operators.comparison;

/**
 * @author sebkun
 */
public abstract class Connector<T> implements arithmetic, comparison, bitwise {

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

