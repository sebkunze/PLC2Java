package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface LOGIC {

    Connector<Boolean> and(Connector c)
            throws NonSupportedOperationException;

    Connector<Boolean> or(Connector c)
            throws NonSupportedOperationException;

    Connector<Boolean> not()
            throws NonSupportedOperationException;
}