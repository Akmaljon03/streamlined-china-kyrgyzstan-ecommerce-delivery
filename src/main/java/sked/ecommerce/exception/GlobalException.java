package sked.ecommerce.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class GlobalException {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<Object> customException(CustomException e) {
        ApiResponse apiResponse = new ApiResponse(e.getMessage(), e.getHttpStatus());
        return new ResponseEntity<>(apiResponse, e.getHttpStatus());
    }
}
