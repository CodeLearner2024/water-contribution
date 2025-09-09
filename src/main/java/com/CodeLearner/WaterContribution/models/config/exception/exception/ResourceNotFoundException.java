package com.CodeLearner.WaterContribution.models.config.exception.exception;

/**
 * @author Franck Sgen Lecroyant The global Resource Exception to be thrown
 */
@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
