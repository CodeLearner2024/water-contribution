/**
 *
 */
package com.CodeLearner.WaterContribution.models.config.exception.exception;

/**
 * @author Franck Sgen Lecroyant
 */
@SuppressWarnings("serial")
public class InvalidInputExceptionMessage extends RuntimeException {

    public InvalidInputExceptionMessage(String message) {
        super(message);
    }
}
