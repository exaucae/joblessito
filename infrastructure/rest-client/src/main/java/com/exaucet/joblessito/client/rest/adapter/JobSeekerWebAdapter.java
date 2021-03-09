package com.exaucet.joblessito.client.rest.adapter;

import com.exaucet.joblessito.application.jobSeeker.api.persistence.IGetAllJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.api.persistence.ISaveJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.api.persistence.ISearchJobSeekerService;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.client.rest.controller.IJobSeekerRestController;
import com.exaucet.joblessito.common.annotation.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebAdapter
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class JobSeekerWebAdapter implements IJobSeekerRestController {

    private final IGetAllJobSeekerService getAllJobSeekerService;
    private final ISaveJobSeekerService saveJobSeekerService;
    private final ISearchJobSeekerService searchJobSeekerService;

    @Override
    public List<JobSeeker> getAll() {
        return new ArrayList<>(getAllJobSeekerService.handle()
                .orElse(new HashSet<>()));
    }

    @Override
    public JobSeeker create(JobSeeker dto) {
        return saveJobSeekerService.handle(dto)
                .orElse(null);
    }

    @Override
    public Set<JobSeeker> getSeekersBy(String specs) {
        return searchJobSeekerService.handle(specs).orElse(null);
    }
}

