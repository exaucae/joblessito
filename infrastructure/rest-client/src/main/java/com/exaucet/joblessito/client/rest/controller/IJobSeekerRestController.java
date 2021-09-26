package com.exaucet.joblessito.client.rest.controller;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.common.annotation.MethodLogger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.exaucet.joblessito.client.rest.common.BaseUrl.BASE_URL_JOBLESS;
import static com.exaucet.joblessito.client.rest.common.Version.V1;

@RestController
@RequestMapping(V1 + BASE_URL_JOBLESS)
public interface IJobSeekerRestController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/seekers")
    @MethodLogger
    List<JobSeeker> getAll();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/seekers")
    @MethodLogger
    JobSeeker create(@RequestBody  final JobSeeker jobSeeker);


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/seekers/{query}")
    @MethodLogger
    Set<JobSeeker> getSeekersBy(@PathVariable(required = false, name = "query") String query);

}
