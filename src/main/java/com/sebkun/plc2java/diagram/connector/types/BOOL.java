package com.sebkun.plc2java.diagram.connector.types;

import com.sebkun.plc2java.diagram.connector.Connector;

public class BOOL extends Connector {

    public BOOL(Boolean bool) {

        this.setValue(bool);
    }

    @Override
    public Connector and(Connector c) {

        return new BOOL((Boolean) this.getValue() && (Boolean) c.getValue());
    }

    @Override
    public Connector or(Connector c) {

        return new BOOL((Boolean) this.getValue() || (Boolean) c.getValue());
    }

    @Override
    public Connector not() {

        return new BOOL(!(Boolean) this.getValue());
    }

    @Override
    public BOOL eq(Connector c) {

        return new BOOL((Boolean) this.getValue() == (Boolean) c.getValue());
    }

    @Override
    public Connector ge(Connector c) {
        return null;
    }

    @Override
    public Connector gt(Connector c) {
        return null;
    }

    @Override
    public Connector le(Connector c) {
        return null;
    }

    @Override
    public Connector lt(Connector c) {
        return null;
    }

    @Override
    public Connector ne(Connector c) {

        return new BOOL((Boolean) this.getValue() != (Boolean) c.getValue());
    }
}