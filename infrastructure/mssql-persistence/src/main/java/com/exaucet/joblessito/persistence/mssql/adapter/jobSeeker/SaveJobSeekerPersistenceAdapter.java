package com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISaveJobSeekerPort;
import com.exaucet.joblessito.common.annotation.PersistenceAdapter;
import com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker.mapper.IJobSeekerPersistenceMapper;
import com.exaucet.joblessito.persistence.mssql.adapter.parent.AbstractSaveJpaAdapter;
import com.exaucet.joblessito.persistence.mssql.entity.JobSeekerEntity;
import com.exaucet.joblessito.persistence.mssql.repository.IJobSeekerRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@SuppressWarnings("unchecked")
@PersistenceAdapter
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SaveJobSeekerPersistenceAdapter extends AbstractSaveJpaAdapter implements ISaveJobSeekerPort {

    private final IJobSeekerRepository repository;

    @Setter(onMethod_ = @Autowired)
    private IJobSeekerPersistenceMapper mapper;

    @Override
    public Optional<JobSeeker> handle(SaveJobSeekerCommand command) {
        JobSeekerEntity entity = mapper.saveJobSeekerCommandToEntity(command);
        return save(entity);
    }

    @Override
    protected IJobSeekerRepository getRepository() {
        return repository;
    }

    @Override
    protected IJobSeekerPersistenceMapper getMapper() {
        return mapper;
    }
}
