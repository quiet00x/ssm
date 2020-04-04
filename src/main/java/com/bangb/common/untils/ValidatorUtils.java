package com.bangb.common.untils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.bangb.common.exception.BusinessException;

public class ValidatorUtils {
	
	private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws BusinessException  校验不通过，BusinessException
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws BusinessException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new BusinessException(msg.toString());
        }
    }

}
