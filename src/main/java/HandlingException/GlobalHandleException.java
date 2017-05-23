package HandlingException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * Created by ahmed on 5/23/2017.
 */
@ControllerAdvice
public class GlobalHandleException {
    // --------------------------------- method To Handle Exception  ------------------------------

    @ExceptionHandler(value = NullPointerException.class)
    public String HandlingNullPOinter() {


        return "NullPointerException";
    }

    @ExceptionHandler(value = IOException.class)
    public String handlingIoException() {


        return "IOException";
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public String handlingArithmeticException() {


        return "ArithmeticException";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String GlobalException() {


        return "Exception";
    }

}
