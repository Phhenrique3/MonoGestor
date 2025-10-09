package com.example.MonoGestor.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFound(ResourceNotFoundException ex) {
        ModelAndView mav = new ModelAndView("error"); // nome do template HTML
        mav.addObject("error", "Recurso não encontrado");
        mav.addObject("message", ex.getMessage());
        mav.addObject("timestamp", LocalDateTime.now());
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGenericException(Exception ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("error", "Erro interno no servidor");
        mav.addObject("message", ex.getMessage());
        mav.addObject("timestamp", LocalDateTime.now());
        return mav;
    }
}
