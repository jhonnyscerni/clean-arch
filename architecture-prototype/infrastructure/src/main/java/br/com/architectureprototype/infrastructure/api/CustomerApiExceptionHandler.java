package br.com.architectureprototype.infrastructure.api;

import br.com.architectureprototype.domain.customer.exception.BusinessException;
import br.com.architectureprototype.domain.customer.exception.NotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerApiExceptionHandler extends ResponseEntityExceptionHandler {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    private ResponseEntity exceptions(NotFoundException exception) {
        this.logger.error(exception.getMessage(), exception);
        Map attributes = new HashMap() {{
            put("resource", exception.getResourceName());
            put("value", exception.getId());
        }};
        return new ResponseEntity(attributes, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    private ResponseEntity exceptions(BusinessException exception) {
        this.logger.error(exception.getMessage(), exception);
        Map attributes = new HashMap() {{
            put("message", exception.getMessage());
        }};
        return new ResponseEntity(attributes, HttpStatus.BAD_REQUEST);
    }

}
