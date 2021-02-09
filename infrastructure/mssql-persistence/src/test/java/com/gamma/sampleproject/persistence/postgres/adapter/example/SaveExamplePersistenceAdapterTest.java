package com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort.SaveJobSeekerCommand;
import com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker.mapper.IJobSeekerPersistenceMapper;
import com.exaucet.joblessito.persistence.mssql.entity.JobSeekerEntity;
import com.exaucet.joblessito.persistence.mssql.repository.IJobSeekerRepository;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class SaveJobSeekerPersistenceAdapterTest {

    private final EasyRandomParameters parameters = new EasyRandomParameters().excludeField(FieldPredicates.named("validator"));
    private final EasyRandom generator = new EasyRandom(parameters);

    private final IJobSeekerRepository repository = mock(IJobSeekerRepository.class);
    private final IJobSeekerPersistenceMapper mapper = mock(IJobSeekerPersistenceMapper.class);

    private final SaveJobSeekerPersistenceAdapter adapter = new SaveJobSeekerPersistenceAdapter(repository);

    @BeforeEach
    void setup() {
        adapter.setMapper(mapper);
    }

    @Test
    void should_save_command_and_return_empty() {
        // GIVEN
        SaveJobSeekerCommand command = generator.nextObject(SaveJobSeekerCommand.class);
        JobSeekerEntity entity = generator.nextObject(JobSeekerEntity.class);

        doReturn(entity).when(mapper).saveJobSeekerCommandToEntity(command);
        doThrow(new IllegalArgumentException()).when(repository).save(entity);

        // WHEN
        Optional<JobSeeker> result = adapter.handle(command);

        // THEN
        assertThat(result).isEmpty();
        then(mapper).should().saveJobSeekerCommandToEntity(command);
        then(repository).should().save(entity);
    }

    @Test
    void should_save_command_and_return_jobSeeker() {
        // GIVEN
        SaveJobSeekerCommand command = generator.nextObject(SaveJobSeekerCommand.class);
        JobSeekerEntity entity = generator.nextObject(JobSeekerEntity.class);
        JobSeekerEntity entitySaved = generator.nextObject(JobSeekerEntity.class);
        JobSeeker jobSeeker = generator.nextObject(JobSeeker.class);

        doReturn(entity).when(mapper).saveJobSeekerCommandToEntity(command);
        doReturn(entitySaved).when(repository).save(entity);
        doReturn(jobSeeker).when(mapper).entityToModel(entitySaved);

        // WHEN
        Optional<JobSeeker> result = adapter.handle(command);

        // THEN
        assertThat(result).contains(jobSeeker);
        then(mapper).should().saveJobSeekerCommandToEntity(command);
        then(repository).should().save(entity);
        then(mapper).should().entityToModel(entitySaved);
    }

}
