package com.csi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String msg) {
        super(msg);
    }
}
