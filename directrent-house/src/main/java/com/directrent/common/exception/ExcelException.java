package com.directrent.common.exception;

/**
 * @description:
 * @author: YX
 * @date: 2020/9/1 22:30
 */
public class ExcelException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExcelException(String message) {
        super(message);
    }
}