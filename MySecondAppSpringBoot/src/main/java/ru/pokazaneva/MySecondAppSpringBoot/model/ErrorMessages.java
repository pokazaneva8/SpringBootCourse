package ru.pokazaneva.MySecondAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Неподдерживаемый код"),
    UNKNOWN("Неподдерживаемая ошибка");

    private final String description;
    ErrorMessages(String description){
        this.description = description;
    }
    @JsonValue
    public String getName(){
        return description;
    }
}
