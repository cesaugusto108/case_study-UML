package ces.augusto108.uml_casestudy.controllers.handlers;

import ces.augusto108.uml_casestudy.services.exceptions.InstanceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<StandardError> instanceNotFoundHandler(
            InstanceNotFoundException e,
            HttpServletRequest httpServletRequest
    ) {
        StandardError standardError = new StandardError(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                httpServletRequest.getMethod()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}
