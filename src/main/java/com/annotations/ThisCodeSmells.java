package com.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Smells.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThisCodeSmells {
    String name();
}
