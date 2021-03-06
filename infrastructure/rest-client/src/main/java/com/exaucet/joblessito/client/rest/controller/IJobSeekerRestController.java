package com.exaucet.joblessito.client.rest.controller;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.common.annotation.MethodLogger;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.exaucet.joblessito.client.rest.common.BaseUrl.BASE_URL_JOBLESS;
import static com.exaucet.joblessito.client.rest.common.Version.V1;

@RestController
@RequestMapping(V1 + BASE_URL_JOBLESS)
public interface IJobSeekerRestController {

    @GetMapping("/seekers")
    @MethodLogger
    List<JobSeeker> getAll();

    @PostMapping
    @MethodLogger
    JobSeeker create(@RequestBody final JobSeeker dto);


    @GetMapping("/seekers/search")
    Set<JobSeeker> getSeekersBy(@SearchSpec Specification<JobSeeker> specs);
}
