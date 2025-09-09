/**
 *
 */
package com.CodeLearner.WaterContribution.models.config.exception.exception;

/**
 * @author Franck Sgen Lecroyant
 */
@SuppressWarnings("serial")
public class ApiCallException extends RuntimeException {

    public ApiCallException(String message) {
        super(message);
    }
}
