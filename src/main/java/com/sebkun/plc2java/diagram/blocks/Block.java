package com.sebkun.plc2java.diagram.blocks;

/**
 * @author sebkun
 */
public enum Block {

    // arithmetic blocks
    ADD  ("ADD"),
    DIV  ("DIV"),
    EXPT ("EXPT"),
    MOD  ("MOD"),
    MOVE ("MOVE"),
    MUL  ("MUL"),
    SUB  ("SUB"),

    // bit shift block
    ROL  ("ROL"),
    ROR  ("ROR"),
    SHL  ("SHL"),
    SHR  ("SHR"),

    // bitwise blocks
    AND  ("AND"),
    NOT  ("NOT"),
    OR   ("OR"),
    XOR  ("XOR"),

    // comparison blocks
    EQ   ("EQ"),
    GE   ("GE"),
    GT   ("GT"),
    LE   ("LE"),
    LT   ("LT"),
    NE   ("NE"),

    // standard blocks
    TOF  ("ROF"),
    TON  ("TON");

    private String functionBlock;

    Block(String functionBlock) {
        this.functionBlock = functionBlock;
    }

    public String getFunctionBlock() {
        return functionBlock;
    }

    public static boolean isArithmeticFunctionBlock(String functionBlock) {

        switch (Block.valueOf(functionBlock)) {

            case ADD:
            case DIV:
            case EXPT:
            case MOD:
            case MOVE:
            case MUL:
            case SUB:
                return true;

            default:
                return false;
        }
    }

    public static boolean isBitShiftFunctionBlock(String functionBlock) {

        switch (Block.valueOf(functionBlock)) {

            case ROL:
            case ROR:
            case SHL:
            case SHR:
                return true;

            default:
                return false;
        }
    }

    public static boolean isBitwiseFunctionBlock(String functionBlock) {

        switch (Block.valueOf(functionBlock)) {

            case AND:
            case NOT:
            case OR:
            case XOR:
                return true;

            default:
                return false;
        }
    }

    public static boolean isComparisonFunctionBlock(String functionBlock) {

        switch (Block.valueOf(functionBlock)) {

            case EQ:
            case GE:
            case GT:
            case LE:
            case LT:
            case NE:
                return true;

            default:
                return false;
        }
    }

    public static boolean isStandardFunctionBlock(String functionBlock) {
        return false;
    }
}
