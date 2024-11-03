package ru.pokazaneva.MySecondAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.pokazaneva.MySecondAppSpringBoot.exception.UnsupportedCodeException;
import ru.pokazaneva.MySecondAppSpringBoot.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult)
            throws ValidationFailedException, UnsupportedCodeException;
}
