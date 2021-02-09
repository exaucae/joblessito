package com.exaucet.joblessito.application.jobSeeker.mapper;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort;
import com.exaucet.joblessito.common.annotation.Mapper;

@Mapper
public class JobSeekerMapper {

    public ISaveJobSeekerPort.SaveJobSeekerCommand jobSeekerToSaveJobSeekerCommand(JobSeeker jobSeeker) {
        return new ISaveJobSeekerPort.SaveJobSeekerCommand(
                jobSeeker.getId(), jobSeeker.getAge(), jobSeeker.getEmail(), jobSeeker.getEducation(), jobSeeker.getUsername());
    }
}
