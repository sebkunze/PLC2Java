package com.sebkun.plc2java.diagram.connector.operators;

import com.sebkun.plc2java.diagram.connector.Connector;

/**
 * @author sebkun
 */
public interface LOGIC {

    Connector and(Connector c);

    Connector or(Connector c);

    Connector not();
}