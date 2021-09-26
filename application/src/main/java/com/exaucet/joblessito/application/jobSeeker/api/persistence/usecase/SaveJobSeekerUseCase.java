package com.exaucet.joblessito.application.jobSeeker.api.persistence.usecase;

import com.exaucet.joblessito.common.annotation.UseCase;
import com.exaucet.joblessito.application.jobSeeker.api.persistence.ISaveJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.mapper.JobSeekerMapper;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort.SaveJobSeekerCommand;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SaveJobSeekerUseCase implements ISaveJobSeekerService {

    private final ISaveJobSeekerPort port;

   @Setter(onMethod_ = @Autowired)
    private JobSeekerMapper mapper;

    @Override
    public Optional<JobSeeker> handle(JobSeeker jobSeeker) {
        SaveJobSeekerCommand command = mapper.jobSeekerToSaveJobSeekerCommand(jobSeeker);
       return Optional.of(
               port.handle(command)
                       .orElseThrow(JobSeekerSaveException::new)
       );
    }
}
