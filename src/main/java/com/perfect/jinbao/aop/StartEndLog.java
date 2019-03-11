package com.perfect.jinbao.aop;



import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StartEndLog {


}
