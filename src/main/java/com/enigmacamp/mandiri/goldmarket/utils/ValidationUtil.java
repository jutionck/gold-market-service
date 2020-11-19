package com.enigmacamp.mandiri.goldmarket.utils;

import com.enigmacamp.mandiri.goldmarket.model.nasabah.CreateNasabahRequest;
import org.hibernate.mapping.Any;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtil {

    Validator validator;
    public void validation(CreateNasabahRequest any) {

        Set<ConstraintViolation<CreateNasabahRequest>> constraintViolations = validator.validate(any);
        if(constraintViolations.size() != 0) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
