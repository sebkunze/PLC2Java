package com.sebkun.plc2java.diagram.connector.types;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

/**
 * @author sebkun
 */
public class INT extends Connector<Integer> {

    public INT(int localId, Integer value) {
        super(localId, value);
    }

    @Override
    public Integer add(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() + i.getValue();
    }

    @Override
    public Integer div(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() / i.getValue();
    }

    @Override
    public Integer expt(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Integer mod(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() % i.getValue();
    }

    @Override
    public Integer move(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public Integer mul(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() * i.getValue();
    }

    @Override
    public Integer sub(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() - i.getValue();
    }

    @Override
    public boolean and(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean or(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean xor(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean not()
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean eq(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() == i.getValue();
    }

    @Override
    public boolean ge(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() >= i.getValue();
    }

    @Override
    public boolean gt(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() > i.getValue();
    }

    @Override
    public boolean le(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() <= i.getValue();
    }

    @Override
    public boolean lt(Connector c)
            throws NonSupportedOperationException {

        if(!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() < i.getValue();
    }

    @Override
    public boolean ne(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof INT)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        INT i = (INT) c;

        return this.getValue() != i.getValue();
    }
}