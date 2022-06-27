package edu.miu.waa_lab5_v1.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AopIsAwesomeHeaderException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }
}
