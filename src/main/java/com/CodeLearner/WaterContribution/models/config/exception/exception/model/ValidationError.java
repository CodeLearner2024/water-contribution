package com.CodeLearner.WaterContribution.models.config.exception.exception.model;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Franck Sgen Lecroyant
 * created on 4/5/2024
 */
public class ValidationError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1905122041950251207L;
    private final String field;
    private final String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
