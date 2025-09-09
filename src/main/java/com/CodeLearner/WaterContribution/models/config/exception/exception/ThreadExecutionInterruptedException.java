/**
 *
 */
package com.CodeLearner.WaterContribution.models.config.exception.exception;

/**
 * @author Franck Sgen Lecroyant
 */
@SuppressWarnings("serial")
public class ThreadExecutionInterruptedException extends RuntimeException {

    public ThreadExecutionInterruptedException(String message) {
        super(message);
    }
}
