package com.sebkun.plc2java.diagram.connector;

public class BOOL extends Connector {

    public BOOL(Boolean bool) {

        this.value = bool;
    }

    @Override
    public Connector and(Connector c) {

        return new BOOL((Boolean) this.value && (Boolean) c.value);
    }

    @Override
    public Connector or(Connector c) {

        return new BOOL((Boolean) this.value || (Boolean) c.value);
    }

    @Override
    public Connector not() {

        return new BOOL(!(Boolean) this.value);
    }
}