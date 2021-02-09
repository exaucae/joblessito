package com.exaucet.joblessito.application.jobSeeker.mapper;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort.SaveJobSeekerCommand;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class JobSeekerMapperTest {

    private static final JobSeekerMapper mapper = new JobSeekerMapper();

    private final EasyRandom generator = new EasyRandom();

    @Test
    void should_map_jobSeeker_to_saveJobSeekerCommand() {
        // GIVEN
        JobSeeker jobSeeker = generator.nextObject(JobSeeker.class);

        // WHEN
        SaveJobSeekerCommand command = mapper.jobSeekerToSaveJobSeekerCommand(jobSeeker);

        // THEN
        assertThat(jobSeeker.getCode()).isEqualTo(command.getCode());
    }
}
