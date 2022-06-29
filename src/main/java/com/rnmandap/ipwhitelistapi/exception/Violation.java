package com.rnmandap.ipwhitelistapi.exception;

public class Violation {

    private final String fieldname;
    private final String message;

    public Violation(String fieldname, String message) {
        this.fieldname = fieldname;
        this.message = message;
    }

    public String getFieldname() {
        return fieldname;
    }

    public String getMessage() {
        return message;
    }
}
