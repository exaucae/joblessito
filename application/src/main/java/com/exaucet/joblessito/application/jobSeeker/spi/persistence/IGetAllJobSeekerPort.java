package com.exaucet.joblessito.application.jobSeeker.spi.persistence;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;

import java.util.Optional;
import java.util.Set;

public interface IGetAllJobSeekerPort {
    Optional<Set<JobSeeker>> handle();
}
