package com.exaucet.joblessito.application.jobSeeker.api.persistence.usecase;

import com.exaucet.joblessito.application.exception.AbstractDomaineSaveException;

class JobSeekerSaveException extends AbstractDomaineSaveException {
    @Override
    public String getDomaineName() {
        return "JobSeeker";
    }
}
