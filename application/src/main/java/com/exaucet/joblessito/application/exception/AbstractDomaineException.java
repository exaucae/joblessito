package com.exaucet.joblessito.application.exception;

import lombok.Getter;

abstract class AbstractDomaineException extends RuntimeException {
    @Getter
    private String applicationeName;
}
