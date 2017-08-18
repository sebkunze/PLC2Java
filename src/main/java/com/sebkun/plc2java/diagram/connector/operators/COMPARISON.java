package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface COMPARISON {

    Connector<Boolean> eq(Connector c)
            throws NonSupportedOperationException;

    Connector<Boolean> ge(Connector c)
            throws NonSupportedOperationException;

    Connector<Boolean> gt(Connector c)
            throws NonSupportedOperationException;

    Connector<Boolean> le(Connector c)
            throws NonSupportedOperationException;

    Connector<Boolean> lt(Connector c)
            throws NonSupportedOperationException;

    Connector<Boolean> ne(Connector c)
            throws NonSupportedOperationException;
}
