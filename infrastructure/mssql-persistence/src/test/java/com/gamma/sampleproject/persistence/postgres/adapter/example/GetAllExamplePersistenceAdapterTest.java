package com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker.mapper.IJobSeekerPersistenceMapper;
import com.exaucet.joblessito.persistence.mssql.entity.JobSeekerEntity;
import com.exaucet.joblessito.persistence.mssql.repository.IJobSeekerRepository;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GetAllJobSeekerPersistenceAdapterTest {

    private final EasyRandomParameters parameters = new EasyRandomParameters().excludeField(FieldPredicates.named("validator"));
    private final EasyRandom generator = new EasyRandom(parameters);

    private final IJobSeekerRepository repository = mock(IJobSeekerRepository.class);
    private final IJobSeekerPersistenceMapper mapper = mock(IJobSeekerPersistenceMapper.class);

    private final GetAllJobSeekerPersistenceAdapter adapter = new GetAllJobSeekerPersistenceAdapter(repository);

    @BeforeEach
    void setup() {
        adapter.setMapper(mapper);
    }

    @Test
    void should_find_all_jobSeeker() {
        // GIVEN
        int NUMBER_ENTITIES = 3;
        List<JobSeekerEntity> entities = generator.objects(JobSeekerEntity.class, NUMBER_ENTITIES)
                .collect(Collectors.toList());

        List<JobSeeker> jobSeekers =  generator.objects(JobSeeker.class, NUMBER_ENTITIES)
                .collect(Collectors.toList());

        doReturn(entities).when(repository).findAll();
        when(mapper.entityToModel(any(JobSeekerEntity.class)))
                .thenReturn(jobSeekers.get(0))
                .thenReturn(jobSeekers.get(1))
                .thenReturn(jobSeekers.get(2));

        // WHEN
        Optional<Set<JobSeeker>> result = adapter.handle();

        // THEN
        List<JobSeeker> resultList = new ArrayList<>(result.get());
        jobSeekers.sort(Comparator.comparing(JobSeeker::getCode));
        resultList.sort(Comparator.comparing(JobSeeker::getCode));
        assertEquals(jobSeekers.size(), resultList.size());

        for (int i = 0; i < resultList.size(); i++)
            assertThat(jobSeekers.get(i)).isEqualToIgnoringGivenFields(resultList.get(i));

        verify(repository).findAll();
        verify(mapper, times(NUMBER_ENTITIES)).entityToModel(any(JobSeekerEntity.class));
    }

}
