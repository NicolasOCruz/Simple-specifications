package com.nicolascruz.specification.repositories.specification;

public enum QueryOperator {
    EQUALS, NOT_EQUALS, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, LIKE, IN;

    static QueryOperator getSimpleOperation(String op) {
        //return the OPERATOR
        if (op.equals(">"))
            return GREATER_THAN;
        else if (op.equals(">-"))
            return GREATER_THAN_OR_EQUAL;
        else if (op.equals("<"))
            return LESS_THAN;
        else if (op.equals("<-"))
            return LESS_THAN_OR_EQUAL;
        else if (op.equals("-"))
            return EQUALS;
        else if (op.equals("!-"))
            return NOT_EQUALS;
        else if (op.equals(":"))
            return LIKE;
        else if (op.equals("$"))
            return IN;
        else throw new RuntimeException("Operator not found");
    }
}
