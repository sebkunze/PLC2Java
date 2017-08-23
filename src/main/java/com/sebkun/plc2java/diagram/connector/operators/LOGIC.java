package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface LOGIC {

    boolean and(Connector c)
            throws NonSupportedOperationException;

    boolean or(Connector c)
            throws NonSupportedOperationException;

    boolean xor(Connector c)
            throws NonSupportedOperationException;

    boolean not()
            throws NonSupportedOperationException;
}