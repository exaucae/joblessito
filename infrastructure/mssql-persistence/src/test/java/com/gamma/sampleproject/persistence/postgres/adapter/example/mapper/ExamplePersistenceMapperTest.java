package com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker.mapper;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort.SaveJobSeekerCommand;
import com.exaucet.joblessito.persistence.mssql.entity.JobSeekerEntity;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class JobSeekerPersistenceMapperTest {

    private final EasyRandomParameters parameters = new EasyRandomParameters().excludeField(FieldPredicates.named("validator"));
    private final EasyRandom generator = new EasyRandom(parameters);

    private final IJobSeekerPersistenceMapper mapper = Mappers.getMapper(IJobSeekerPersistenceMapper.class);

    @Test
    void should_map_entity_to_model() {
        // GIVEN
        JobSeekerEntity entity = generator.nextObject(JobSeekerEntity.class);

        // WHEN
        JobSeeker model = mapper.entityToModel(entity);

        // THEN
        assertThat(entity.getCode()).isEqualTo(model.getCode());
    }

    @Test
    void should_map_saveJobSeekerCommand_to_entity() {
        // GIVEN
        SaveJobSeekerCommand command = generator.nextObject(SaveJobSeekerCommand.class);

        // WHEN
        JobSeekerEntity entity = mapper.saveJobSeekerCommandToEntity(command);

        // THEN
        assertThat(command.getCode()).isEqualTo(entity.getCode());
    }
}
