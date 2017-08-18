package com.sebkun.plc2java.diagram.connector.types;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

public class BOOL extends Connector<Boolean> {

    public BOOL(Boolean bool) {

        this.setValue(bool);
    }

    @Override
    public Connector and(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof BOOL)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        BOOL b = (BOOL) c;

        return new BOOL(this.getValue() && b.getValue());
    }

    @Override
    public Connector or(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof BOOL)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        BOOL b = (BOOL) c;

        return new BOOL(this.getValue() || b.getValue());
    }

    @Override
    public Connector not()
            throws NonSupportedOperationException {

        return new BOOL(!this.getValue());
    }

    @Override
    public Connector ge(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Connector gt(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Connector le(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Connector lt(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }
}