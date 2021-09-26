package com.exaucet.joblessito.application.jobSeeker.api.persistence;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;

import java.util.Optional;
import java.util.Set;

public interface ISearchJobSeekerService {

    Optional<Set<JobSeeker>> handle(String specs);
}

