package com.rnmandap.ipwhitelistapi.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {

    private List<Violation> violations = new ArrayList<>();

    public ValidationErrorResponse() {
    }

    public List<Violation> getViolations() {
        return violations;
    }
}
