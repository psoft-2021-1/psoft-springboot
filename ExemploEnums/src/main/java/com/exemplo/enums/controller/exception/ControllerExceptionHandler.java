package com.exemplo.enums.controller.exception;

import com.exemplo.enums.service.excecoes.ExcecaoEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ExcecaoEnum.class)
    public ResponseEntity<ErrorMessage> erroEnum(ExcecaoEnum exp, HttpServletRequest req){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessage erro = new ErrorMessage();
        erro.setMsg(exp.getMessage());
        erro.setError("Enum invalido");
        erro.setStatus(status.value());
        erro.setPath(req.getRequestURI());
        erro.setMethod(req.getMethod());
        return ResponseEntity.status(status).body(erro);
    }
}
