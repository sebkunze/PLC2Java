package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface COMPARISON {

    Connector eq(Connector c);

    Connector ge(Connector c);

    Connector gt(Connector c);

    Connector le(Connector c);

    Connector lt(Connector c);

    Connector ne(Connector c);
}
