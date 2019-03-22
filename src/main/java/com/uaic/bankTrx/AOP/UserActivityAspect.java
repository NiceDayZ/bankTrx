package com.uaic.bankTrx.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Configuration
@Slf4j
public class UserActivityAspect {

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Before("execution(* com.uaic.bankTrx.controller.*.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("Check for user access ");


    }

    @AfterReturning("execution(* com.uaic.bankTrx.controller.*.*(..))")
    public void after(JoinPoint joinPoint){
        log.info("Allowed execution for {}", joinPoint);
    }


    //TODO

    @Before("execution(* com.uaic.bankTrx.service.CustomDetailService.*(..))")
    public void beforeAuth(JoinPoint joinPoint){
        log.info("Trying to auth...");
    }

    @AfterReturning("execution(* com.uaic.bankTrx.service.CustomDetailService.*(..))")
    public void afterAuth(JoinPoint joinPoint){
        log.info("Access granted");
    }

    @AfterThrowing("execution(* com.uaic.bankTrx.service.CustomDetailService.*(..))")
    public void afterFailedAuth(JoinPoint joinPoint){
        log.info("Access denied");
    }


}
