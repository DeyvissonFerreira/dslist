package com.devsuperior.dslist.validation;

import com.devsuperior.dslist.dto.ReplacementDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DifferentIndexesValidator implements ConstraintValidator<DifferentIndexes, ReplacementDTO> {

    @Override
    public void initialize(DifferentIndexes constraintAnnotation) {
    }

    @Override
    public boolean isValid(ReplacementDTO request, ConstraintValidatorContext context) {
        return request.getSourceIndex() != request.getTargetIndex();
    }
}
