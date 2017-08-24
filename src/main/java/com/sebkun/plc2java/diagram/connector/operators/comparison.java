package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface comparison {

    boolean eq(Connector c)
            throws NonSupportedOperationException;

    boolean ge(Connector c)
            throws NonSupportedOperationException;

    boolean gt(Connector c)
            throws NonSupportedOperationException;

    boolean le(Connector c)
            throws NonSupportedOperationException;

    boolean lt(Connector c)
            throws NonSupportedOperationException;

    boolean ne(Connector c)
            throws NonSupportedOperationException;
}
