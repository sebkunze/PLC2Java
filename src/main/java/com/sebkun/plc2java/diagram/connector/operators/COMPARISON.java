package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface COMPARISON {

    Connector eq(Connector c)
            throws NonSupportedOperationException;

    Connector ge(Connector c)
            throws NonSupportedOperationException;

    Connector gt(Connector c)
            throws NonSupportedOperationException;

    Connector le(Connector c)
            throws NonSupportedOperationException;

    Connector lt(Connector c)
            throws NonSupportedOperationException;

    Connector ne(Connector c)
            throws NonSupportedOperationException;
}
