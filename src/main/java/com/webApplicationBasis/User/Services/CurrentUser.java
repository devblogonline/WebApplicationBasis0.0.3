package com.webApplicationBasis.User.Services;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * Annotate Spring MVC method arguments with this annotation to indicate you
 * wish to specify the argument with the value of the current
 * {@link Authentication#getPrincipal()} found on the
 * {@link SecurityContextHolder}.
 *
 * <p>
 * Creating your own annotation that uses {@link AuthenticationPrincipal} as a
 * meta annotation creates a layer of indirection between your code and Spring
 * Security's. For simplicity, you could instead use the
 * {@link AuthenticationPrincipal} directly.
 * </p>
 *
 * @author Rob Winch
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}