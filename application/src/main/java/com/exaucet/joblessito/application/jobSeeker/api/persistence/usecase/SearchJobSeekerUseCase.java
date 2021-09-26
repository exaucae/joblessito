package com.exaucet.joblessito.application.jobSeeker.api.persistence.usecase;

import com.exaucet.joblessito.application.jobSeeker.api.persistence.ISearchJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISearchJobSeekerPort;
import com.exaucet.joblessito.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

@UseCase
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SearchJobSeekerUseCase implements ISearchJobSeekerService {

    private final ISearchJobSeekerPort port;

    @Override
    public Optional<Set<JobSeeker>> handle(String query) {
        return port.handle(query);
    }

}
