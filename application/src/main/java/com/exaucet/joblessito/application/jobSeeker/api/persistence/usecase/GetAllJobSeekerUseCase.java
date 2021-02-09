package com.exaucet.joblessito.application.jobSeeker.api.persistence.usecase;

import lombok.RequiredArgsConstructor;
import com.exaucet.joblessito.common.annotation.UseCase;
import com.exaucet.joblessito.application.jobSeeker.api.persistence.IGetAllJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.IGetAllJobSeekerPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

@UseCase
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GetAllJobSeekerUseCase implements IGetAllJobSeekerService {

    private final IGetAllJobSeekerPort port;

    @Override
    public Optional<Set<JobSeeker>> handle() {
        return port.handle();
    }
}
