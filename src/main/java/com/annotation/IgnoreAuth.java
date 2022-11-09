package com.annotation;

import java.lang.annotation.*;

/**
 * Ignore Token Verification
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
