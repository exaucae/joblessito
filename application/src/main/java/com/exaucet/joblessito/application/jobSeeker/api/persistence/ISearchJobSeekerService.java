package com.exaucet.joblessito.application.jobSeeker.api.persistence;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.Set;

public interface ISearchJobSeekerService {

    Optional<Set<JobSeeker>> handle(Specification<JobSeeker> specs);
}

