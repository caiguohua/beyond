package com.cgh.spring.jpa.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class Exception {

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException e) {
        ModelAndView m = new ModelAndView();
        m.addObject("zhpException",e.getMessage());
        m.setViewName("templates/error/500");
        return m;
   }


}
