package com.exaucet.joblessito.client.rest.adapter;

import com.exaucet.joblessito.application.jobSeeker.api.persistence.IGetAllJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.api.persistence.ISaveJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.empty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static java.util.Optional.of;

class JobSeekerWebAdapterTest {

    private final EasyRandom generator = new EasyRandom();
    private final IGetAllJobSeekerService getAllJobSeekerService = mock(IGetAllJobSeekerService.class);
    private final ISaveJobSeekerService saveJobSeekerService = mock(ISaveJobSeekerService.class);
    private final JobSeekerWebAdapter adapter = new JobSeekerWebAdapter(getAllJobSeekerService, saveJobSeekerService);

    @Test
    void should_get_all_and_return_list_jobSeeker() {
        // GIVEN
        int NUMBER_ENTITIES = 3;
        Set<JobSeeker> jobSeekers = generator.objects(JobSeeker.class, NUMBER_ENTITIES).collect(Collectors.toSet());
        doReturn(of(jobSeekers)).when(getAllJobSeekerService).handle();

        // WHEN
        List<JobSeeker> result = adapter.getAll();

        // THEN
        assertThat(jobSeekers).containsAll(result);
    }

    @Test
    void should_get_all_and_return_empty_list() {
        // GIVEN
        doReturn(empty()).when(getAllJobSeekerService).handle();

        // WHEN
        List<JobSeeker> result = adapter.getAll();

        // THEN
        assertThat(result).isEmpty();
    }

    @Test
    void should_create_and_return_jobSeeker() {
        // GIVEN
        JobSeeker dto = generator.nextObject(JobSeeker.class);
        JobSeeker expectedJobSeeker = generator.nextObject(JobSeeker.class);
        doReturn(of(expectedJobSeeker)).when(saveJobSeekerService).handle(dto);

        // WHEN
        JobSeeker result = adapter.create(dto);

        // THEN
        assertThat(expectedJobSeeker).isEqualTo(result);
    }

    @Test
    void should_create_and_return_null() {
        // GIVEN
        JobSeeker dto = generator.nextObject(JobSeeker.class);
        doReturn(empty()).when(saveJobSeekerService).handle(dto);

        // WHEN
        JobSeeker result = adapter.create(dto);

        // THEN
        assertThat(result).isNull();
    }
}
