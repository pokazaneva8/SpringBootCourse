package ru.pokazaneva.MySecondAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.pokazaneva.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.pokazaneva.MySecondAppSpringBoot.exception.ValidationFailedException;
import java.util.Objects;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult)
            throws ValidationFailedException, UnsupportedCodeException {
        if (Objects.equals(bindingResult.getRawFieldValue("uid"), "123")){
            log.error("uid равный '123' не поддерживается, throw UnsupportedException");
            throw new UnsupportedCodeException("uid равный '123' не поддерживается");
        }

        if (bindingResult.hasErrors()) {
            log.error("bindingResult имеет ошибки, throw ValidationFailedException");
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
