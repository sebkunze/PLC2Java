package com.sebkun.plc2java.diagram.connector.types;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

/**
 * @author sebkun
 */
public class INT extends Connector<Integer> {

    public INT(Integer value) {

        this.setValue(value);
    }

    @Override
    public Connector and(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Connector or(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Connector not()
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Connector eq(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return new BOOL(this.getValue() == i.getValue());
    }

    @Override
    public Connector ge(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return new BOOL(this.getValue() >= i.getValue());
    }

    @Override
    public Connector gt(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return new BOOL(this.getValue() > i.getValue());
    }

    @Override
    public Connector le(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return new BOOL(this.getValue() <= i.getValue());
    }

    @Override
    public Connector lt(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return new BOOL(this.getValue() < i.getValue());
    }

    @Override
    public Connector ne(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return new BOOL(this.getValue() != i.getValue());
    }
}