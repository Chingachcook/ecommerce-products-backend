package com.example.ecommerce.model;

import java.util.List;

public class ErrorResponse {
    protected List<ErrorItem> errors;

    public ErrorResponse() {
    }

    public void addError(ErrorItem error) {
        this.errors.add(error);
    }
}
