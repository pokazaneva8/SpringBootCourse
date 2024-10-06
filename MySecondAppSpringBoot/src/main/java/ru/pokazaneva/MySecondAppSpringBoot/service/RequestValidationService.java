package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.pokazaneva.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.pokazaneva.MySecondAppSpringBoot.exception.ValidationFailedException;
import java.util.Objects;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult)
            throws ValidationFailedException, UnsupportedCodeException {
        if (Objects.equals(bindingResult.getRawFieldValue("uid"), "123")){
            throw new UnsupportedCodeException("uid равный '123' не поддерживается");
        }

        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
