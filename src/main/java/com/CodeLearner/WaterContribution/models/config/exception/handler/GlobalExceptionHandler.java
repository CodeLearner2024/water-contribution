package com.CodeLearner.WaterContribution.models.config.exception.handler;


import com.CodeLearner.WaterContribution.models.config.exception.LocalizationService;
import com.CodeLearner.WaterContribution.models.config.exception.exception.*;
import com.CodeLearner.WaterContribution.models.config.exception.exception.model.ValidationError;
import com.CodeLearner.WaterContribution.models.config.exception.exception.model.ValidationResult;
import com.CodeLearner.WaterContribution.models.config.exception.message.ArgumentNotValidExceptionMessage;
import com.CodeLearner.WaterContribution.models.config.exception.message.ExceptionValueMessageStructure;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Franck Sgen Lecroyant This is the global place where we handle
 * exceptions, both framework built-in and custom ones
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final LocalizationService localizationService;

    @Autowired
    public GlobalExceptionHandler(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiExceptionMessage> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                               WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Resource Not Found",
                webRequest.getDescription(false), exception.getMessage());
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UniqueColumnException.class)
    public ResponseEntity<ApiExceptionMessage> handleUniqueColumnException(UniqueColumnException exception,
                                                                           WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Data uniqueness  breach",
                webRequest.getDescription(false), exception.getMessage());
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = IllegalCallerException.class)
    public ResponseEntity<ApiExceptionMessage> handleUnsupportedMethodCall(IllegalCallerException exception,
                                                                           WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false), "Method Execution Not Allowed");
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ApiExceptionMessage> handleIllegalArgumentException(IllegalArgumentException exception,
                                                                              WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Vous devez parametrez le nombre d'heures normales par jour!");
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.BAD_GATEWAY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ArgumentNotValidExceptionMessage exceptionMessage = new ArgumentNotValidExceptionMessage();
        Map<Object, List<ExceptionValueMessageStructure>> fieldsErrors = new HashMap<>();

        List<ExceptionValueMessageStructure> errorDetails = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            exceptionMessage.setDescription("Some Fields got invalid input data");
            exceptionMessage.setPath(request.getDescription(false));
            errorDetails.add(new ExceptionValueMessageStructure(fieldError.getField(),
                    fieldError.getDefaultMessage(),
                    fieldError.getRejectedValue()));

        });
        fieldsErrors.put("details", errorDetails);
        exceptionMessage.setFieldsErrors(fieldsErrors);
        return new ResponseEntity<>(exceptionMessage, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Http Request Method Not Supported on PATH => %s"
                        .formatted(request.getDescription(false)),
                request.getDescription(false), "You may have issued an http request to the wrong URI");
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ApiExceptionMessage> handleConstrainteViolationException(
            DataIntegrityViolationException exception, WebRequest webRequest) {

        String errorMessageMessageCode = "data.integrity.violation.exception.global.error-message";
        String descriptionMessageMessageCode = "data.integrity.violation.exception.global.description-message";
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                this.localizationService.getLocalizedMessage(errorMessageMessageCode),
                webRequest.getDescription(false),
                this.localizationService.getLocalizedMessage(descriptionMessageMessageCode));
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ApiCallException.class)
    public ResponseEntity<ApiExceptionMessage> handleApiCallException(ApiCallException exception,
                                                                      WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Fetch Operation Failed",
                webRequest.getDescription(false), exception.getMessage());
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ThreadExecutionInterruptedException.class)
    public ResponseEntity<ApiExceptionMessage> handleApiCallException(ThreadExecutionInterruptedException exception,
                                                                      WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Task Interrupted",
                webRequest.getDescription(false), exception.getMessage());
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = InvalidInputExceptionMessage.class)
    public ResponseEntity<ApiExceptionMessage> handleApiCallException(InvalidInputExceptionMessage exception,
                                                                      WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Invalid inputs entered",
                webRequest.getDescription(false), exception.getMessage());
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UnsupportedOperationException.class)
    public ResponseEntity<ApiExceptionMessage> handleUnsupportedOperationException(
            UnsupportedOperationException exception, WebRequest webRequest) {
        String exceptionMessage = isLocalized(exception.getMessage())
                ? this.localizationService.getLocalizedMessage(exception.getMessage())
                : exception.getMessage();
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Unsupported Operation",
                webRequest.getDescription(false), exceptionMessage);
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = AnnotationNotSupportedException.class)
    public ResponseEntity<ApiExceptionMessage> handleAnnotationNotSupportedExceptionException(
            AnnotationNotSupportedException exception, WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Annotation Exception",
                webRequest.getDescription(false), exception.getMessage());
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(HttpServerErrorException.GatewayTimeout.class)
    public ResponseEntity<ApiExceptionMessage> handleGatewayTimeout(
            @SuppressWarnings("unused") HttpServerErrorException.GatewayTimeout exception,
            WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Something went wrong",
                webRequest.getDescription(false), "Network Failure");
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiExceptionMessage> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception, WebRequest webRequest) {
        ApiExceptionMessage apiExceptionMessage = new ApiExceptionMessage(LocalDateTime.now(),
                "Arguments Mismatched",
                webRequest.getDescription(false), "Network Failure");
        // exception
        return new ResponseEntity<>(apiExceptionMessage, HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(BeanPropertyValidationException.class)
    public ResponseEntity<Object> handleBeanPropertyValidationException(BeanPropertyValidationException exception) {
        List<ValidationError> validationErrors = exception.getValidationErrors();
        ValidationResult validationResult = new ValidationResult(exception.getObjectIndex(), validationErrors);
        return new ResponseEntity<>(validationResult, HttpStatus.BAD_REQUEST);
    }



    private boolean isLocalized(String exceptionMessage) {

        int count = 0;
        for (char character : exceptionMessage.toCharArray()) {

            if (character == '.') {
                count++;
            }
        }
        return exceptionMessage.toLowerCase().contains("localization") || count >= 2;

    }

}
