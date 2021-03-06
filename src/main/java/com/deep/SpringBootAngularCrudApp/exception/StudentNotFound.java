package com.deep.SpringBootAngularCrudApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFound extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public StudentNotFound(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : '%s' ",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
