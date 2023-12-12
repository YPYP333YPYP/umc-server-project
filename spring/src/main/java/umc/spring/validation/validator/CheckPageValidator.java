package umc.spring.validation.validator;

import io.swagger.models.auth.In;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer>{

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer values, ConstraintValidatorContext context) {

        boolean isValid = values != null && values >= 0;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_ERROR.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
