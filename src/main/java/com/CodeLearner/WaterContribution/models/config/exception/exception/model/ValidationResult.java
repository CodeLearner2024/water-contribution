package com.CodeLearner.WaterContribution.models.config.exception.exception.model;

import java.util.List;

/**
 * @author Franck Sgen Lecroyant
 * created on 4/8/2024
 */
public class ValidationResult {

    private final int objectIndex;
    private final List<ValidationError> validationError;

    public ValidationResult(int objectIndex, List<ValidationError> validationError) {
        this.objectIndex = objectIndex;
        this.validationError = validationError;
    }

    public int getObjectIndex() {
        return objectIndex;
    }

    public List<ValidationError> getValidationError() {
        return validationError;
    }
}
