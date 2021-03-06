package com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker.mapper;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort.SaveJobSeekerCommand;
import com.exaucet.joblessito.persistence.mssql.adapter.parent.mapper.IGenericMapper;
import com.exaucet.joblessito.persistence.mssql.entity.JobSeekerEntity;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.domain.Specification;

@Mapper
public interface IJobSeekerPersistenceMapper extends IGenericMapper<JobSeeker, JobSeekerEntity> {

    JobSeekerEntity saveJobSeekerCommandToEntity(SaveJobSeekerCommand command);

    Specification<JobSeekerEntity> toEntitySpecs(Specification<JobSeeker> specs);

}
