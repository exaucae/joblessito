package com.exaucet.joblessito.application.jobSeeker.api.persistence.usecase;

import com.exaucet.joblessito.application.jobSeeker.mapper.JobSeekerMapper;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort.SaveJobSeekerCommand;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class SaveJobSeekerUseCaseTest {

    private final ISaveJobSeekerPort port = mock(ISaveJobSeekerPort.class);
    private final JobSeekerMapper mapper = mock(JobSeekerMapper.class);
    private final SaveJobSeekerUseCase adapter = new SaveJobSeekerUseCase(port);

    private final EasyRandomParameters parameters = new EasyRandomParameters().excludeField(FieldPredicates.named("validator"));
    private final EasyRandom generator = new EasyRandom(parameters);


    @BeforeEach
    void setup() {
        adapter.setMapper(mapper);
    }

    @Test
    void should_throws_JobSeekerSaveException() {
        // GIVEN
        JobSeeker jobSeeker = generator.nextObject(JobSeeker.class);
        SaveJobSeekerCommand command = generator.nextObject(SaveJobSeekerCommand.class);

        doReturn(command).when(mapper).jobSeekerToSaveJobSeekerCommand(jobSeeker);
        doReturn(empty()).when(port).handle(command);

        // WHEN
        JobSeekerSaveException thrown = assertThrows(
                JobSeekerSaveException.class,
                () -> adapter.handle(jobSeeker)
        );

        // THEN
        then(mapper).should().jobSeekerToSaveJobSeekerCommand(jobSeeker);
        then(port).should().handle(command);

    }

    @Test
    void should_retrun_saved_JobSeeker() {
        // GIVEN
        JobSeeker jobSeeker = generator.nextObject(JobSeeker.class);
        Optional<JobSeeker> savedJobSeeker = of(generator.nextObject(JobSeeker.class));
        SaveJobSeekerCommand command = generator.nextObject(SaveJobSeekerCommand.class);

        doReturn(command).when(mapper).jobSeekerToSaveJobSeekerCommand(jobSeeker);
        doReturn(savedJobSeeker).when(port).handle(command);

        // WHEN
        Optional<JobSeeker> result = adapter.handle(jobSeeker);

        // THEN
        assertEquals(savedJobSeeker, result);
        then(mapper).should().jobSeekerToSaveJobSeekerCommand(jobSeeker);
        then(port).should().handle(command);

    }
}
