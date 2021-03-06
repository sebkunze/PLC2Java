package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface arithmetic {

    Integer add(Connector c)
            throws NonSupportedOperationException;

    Integer div(Connector c)
            throws NonSupportedOperationException;

    Integer expt(Connector c)
            throws NonSupportedOperationException;

    Integer mod(Connector c)
            throws NonSupportedOperationException;

    Integer move(Connector c)
            throws NonSupportedOperationException;

    Integer mul(Connector c)
            throws NonSupportedOperationException;

    Integer sub(Connector c)
            throws NonSupportedOperationException;
}