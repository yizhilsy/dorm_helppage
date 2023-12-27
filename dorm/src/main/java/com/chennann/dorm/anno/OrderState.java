package com.chennann.dorm.anno;


import com.chennann.dorm.validation.OrderStateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {OrderStateValidation.class})
public @interface OrderState {
    String message() default "waterOrderStatus的值只能是'未接收','运送中'或'已完成'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
