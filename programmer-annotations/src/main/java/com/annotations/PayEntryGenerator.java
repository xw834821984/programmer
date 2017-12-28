package com.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nazi on
 * date： 2017/12/27
 */

//这个注解是告诉编译器用在类上面的，不是用在方法上，也不是用属性上的，是用在类上的
@Target(ElementType.TYPE)
//这个注解是 在处理这个注解的时候是在源码处理的，也就是说打包后运行的时候不在使用，可以理解为对性能无影响
@Retention(RetentionPolicy.SOURCE)
public @interface PayEntryGenerator {
    String packageName();

    Class<?> payEntryTemplete();
}
