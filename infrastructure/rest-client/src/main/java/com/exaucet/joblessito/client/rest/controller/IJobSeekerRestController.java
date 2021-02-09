package com.exaucet.joblessito.client.rest.controller;

import com.exaucet.joblessito.common.annotation.MethodLogger;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.exaucet.joblessito.client.rest.common.Version.V1;
import static com.exaucet.joblessito.client.rest.common.BaseUrl.BASE_URL_JOBLESS;

@RestController
@RequestMapping(V1 + BASE_URL_JOBLESS)
public interface IJobSeekerRestController {

    @GetMapping
    @MethodLogger
    List<JobSeeker> getAll();

    @PostMapping
    @MethodLogger
    JobSeeker create(@RequestBody final JobSeeker dto);
}
