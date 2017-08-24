package com.sebkun.plc2java.diagram.connector.types;

import com.sebkun.plc2java.diagram.connector.Connector;
import com.sebkun.plc2java.diagram.connector.operators.NonSupportedOperationException;

public class BOOL extends Connector<Boolean> {

    /**
     *
     * @param localId
     */
    public BOOL(int localId) {
        super(localId, false);
    }

    /**
     *
     * @param localId
     * @param value
     */
    public BOOL(int localId, Boolean value) {
        super(localId, value);
    }

    @Override
    public Integer add(Connector c) throws NonSupportedOperationException {
        return null;
    }

    @Override
    public Integer div(Connector c) throws NonSupportedOperationException {
        return null;
    }

    @Override
    public Integer expt(Connector c) throws NonSupportedOperationException {
        return null;
    }

    @Override
    public Integer mod(Connector c) throws NonSupportedOperationException {
        return null;
    }

    @Override
    public Integer move(Connector c) throws NonSupportedOperationException {
        return null;
    }

    @Override
    public Integer mul(Connector c) throws NonSupportedOperationException {
        return null;
    }

    @Override
    public Integer sub(Connector c) throws NonSupportedOperationException {
        return null;
    }

    @Override
    public boolean and(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof BOOL)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        BOOL b = (BOOL) c;

        return this.getValue() && b.getValue();
    }

    @Override
    public boolean or(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof BOOL)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        BOOL b = (BOOL) c;

        return this.getValue() || b.getValue();
    }

    @Override
    public boolean xor(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof BOOL)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        BOOL b = (BOOL) c;

        return this.getValue() ^ b.getValue();
    }

    @Override
    public boolean not()
            throws NonSupportedOperationException {

        return !this.getValue();
    }

    @Override
    public boolean eq(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof BOOL)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        BOOL b = (BOOL) c;

        return this.getValue() == b.getValue();
    }

    @Override
    public boolean ge(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean gt(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean le(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean lt(Connector c)
            throws NonSupportedOperationException {

        throw new NonSupportedOperationException(
                String.format("operation not supported for type %s!", getClass().getSimpleName()));
    }

    @Override
    public boolean ne(Connector c)
            throws NonSupportedOperationException {

        if (!(c instanceof BOOL)) {
            throw new NonSupportedOperationException(
                    String.format("operation not supported for type %s!", c.getClass().getSimpleName())
            );
        }

        BOOL b = (BOOL) c;

        return this.getValue() != b.getValue();
    }
}