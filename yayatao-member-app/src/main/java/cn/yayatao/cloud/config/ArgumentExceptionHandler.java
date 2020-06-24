package cn.yayatao.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ArgumentExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArgumentExceptionHandler.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  Object  handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error("参数异常",e);
        return  e.getBindingResult().getFieldError().getField();

    }
}
