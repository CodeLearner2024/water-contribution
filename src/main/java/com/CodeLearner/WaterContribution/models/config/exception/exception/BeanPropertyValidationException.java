package com.CodeLearner.WaterContribution.models.config.exception.exception;


import com.CodeLearner.WaterContribution.models.config.exception.exception.model.ValidationError;

import java.io.Serial;
import java.util.List;

/**
 * @author Franck Sgen Lecroyant
 * created on 4/5/2024
 */
public class BeanPropertyValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1905122041950251207L;
    private final List<ValidationError> validationErrors;
    private final int objectIndex;

    public BeanPropertyValidationException(int objectIndex, List<ValidationError> validationErrors) {
        this.objectIndex = objectIndex;
        this.validationErrors = validationErrors;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public int getObjectIndex() {
        return objectIndex;
    }
}
