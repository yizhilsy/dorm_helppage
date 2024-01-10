package com.shiyulu.validation;

import com.shiyulu.anno.OrderState;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrderStateValidation implements ConstraintValidator<OrderState, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        return s.equals("未接收") || s.equals("运送中") || s.equals("已完成");
    }
}
