package com.thefinestartist.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Bind a field to the bundle data for the specific key.
 * <pre><code>
 * {@literal @}Extra(EXTRA_TITLE) String title;
 * </code></pre>
 */
@Retention(CLASS)
@Target(FIELD)
public @interface Extra {
    String value() default "";
}