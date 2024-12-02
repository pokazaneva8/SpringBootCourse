package com.pokazaneva.MySpringBoot2Dbase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    public static final String SUCCESS_MESSAGE = "Success";
    public static final String ERROR_MESSAGE = "Error";
    private String message;
    private T result;
}