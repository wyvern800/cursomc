package com.ferreira.cursomc.resources.exceptions;

import java.io.Serializable;


/**
 * com.ferreira.cursomc.resources.exceptions
 *
 * @author wyvern800 - http://github.com/wyvern800
 * @created 12/02/2021 - 09:15
 * @project cursomc
 */
public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    public FieldMessage() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
