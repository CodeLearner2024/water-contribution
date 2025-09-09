package com.CodeLearner.WaterContribution.models.config.exception.exception;

import java.time.LocalDateTime;

/**
 * @author Franck Sgen Lecroyant This is the global api exception message
 */
public class ApiExceptionMessage {

    /**
     * The time when an exception is thrown
     */
    private LocalDateTime time;
    /**
     * The short message why the exception occurred
     */
    private String errorMessage;
    /**
     * The path is the request uri
     */
    private String path;
    /**
     * The description is the detailed message about the exception
     */
    private String description;

    public ApiExceptionMessage(LocalDateTime time, String errorMessage, String path, String description) {
        this.time = time;
        this.errorMessage = errorMessage;
        this.path = path;
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
