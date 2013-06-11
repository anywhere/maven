package com.framework.ssm.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

/**
 * Validate that the string is a valid Phone.
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-6-3
 * @description
 * @TODO
 */
@Documented
// 与约束注解关联的验证器
@Constraint(validatedBy = {})
// 约束注解应用的目标元素类型
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
// 约束注解应用的时机
@Retention(RUNTIME)
@ReportAsSingleViolation
@Pattern(regexp = "")
public @interface Phone {
    
    // 约束注解验证时的输出消息
    String message() default "{com.unishine.nms.validation.constraints.Phone.message}";
    
    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};
    
    // 约束注解的有效负载
    Class<? extends Payload>[] payload() default {};
    
    /**
     * @return an additional regular expression the annotated string must match. The default is any string ('.*')
     */
    @OverridesAttribute(constraint = Pattern.class, name = "regexp")
    String regexp() default ".*";
    
    /**
     * @return used in combination with {@link #regexp()} in order to specify a regular expression option
     */
    @OverridesAttribute(constraint = Pattern.class, name = "flags")
    Pattern.Flag[] flags() default {};
    
    /**
     * Defines several {@code @Phone} annotations on the same element.
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        
        Phone[] value();
    }
    
}