package com.ferreira.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * com.ferreira.cursomc.resources.exceptions
 *
 * @author wyvern800 - http://github.com/wyvern800
 * @created 12/02/2021 - 09:17
 * @project cursomc
 */
public class ValidationError extends StandardError{
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }
}
