package com.varchenko.ttshop.exception;

import org.apache.commons.lang3.StringUtils;

public class RepositoryException extends Exception {

    public RepositoryException(String message) {
        super("Fatal data base error" + StringUtils.SPACE + message);
    }
}
