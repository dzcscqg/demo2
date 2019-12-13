package com.example.demo.config;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.CryptoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;

/*
*
 * Created by qwe on 2019/8/2.

*/

@ControllerAdvice
public class NoPermissionException {
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthenticatedException.class)
    public String handleShiroException(Exception ex) {
        System.out.println("没有此权限！");
        return "error/403";
    }


 /*   @ExceptionHandler(ConcurrentAccessException.class)
    public String handleException2(AuthorizationException e) {
        System.out.println(e.getMessage());
        return "error/403";
    }*/

   /* @ExceptionHandler(UnauthorizedException.class)
    public String handleException3(AuthorizationException e) {
        System.out.println("你的级别还不够高,加油吧！少年。");
        return "error/403";
    }

    @ExceptionHandler(ConcurrentAccessException.class)
    public String handleException4(AuthorizationException e) {
        System.out.println("我勒个去，页面被外星人挟持了!");
        return "error/403";
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleException5(AuthorizationException e) {
        return "error/405";
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleException6(AuthorizationException e) {
        return "error/404";
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleException7(AuthorizationException e) {
        return "error/500";
    }*/

/*    @ExceptionHandler(AuthenticationException.class)
    public String chu(){
        System.out.println("无认证");
        return "error/403";
    }*/

}
