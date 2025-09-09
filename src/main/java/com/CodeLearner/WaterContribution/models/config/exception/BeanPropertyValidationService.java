package com.CodeLearner.WaterContribution.models.config.exception;

import com.CodeLearner.WaterContribution.models.config.exception.exception.BeanPropertyValidationException;
import com.CodeLearner.WaterContribution.models.config.exception.exception.model.ValidationError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class BeanPropertyValidationService {
    private final Validator validator;

    @Autowired
    public BeanPropertyValidationService(Validator validator) {
        this.validator = validator;
    }

    public <T> void validateBean(List<T> objectsCollection) {

        int objectIndex = -1;
        for (T object : objectsCollection) {
            List<ValidationError> validationErrors = new ArrayList<>();

            Set<ConstraintViolation<T>> constraintViolations = this.validator.validate(object);
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                ValidationError validationError = new ValidationError(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
                validationErrors.add(validationError);
            }
            objectIndex++;

            if (!validationErrors.isEmpty()) {
                throw new BeanPropertyValidationException(objectIndex, validationErrors);
            }
        }
    }
}
