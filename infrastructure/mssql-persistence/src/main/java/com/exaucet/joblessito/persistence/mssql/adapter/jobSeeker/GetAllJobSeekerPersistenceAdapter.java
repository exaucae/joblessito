package com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker;

import com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker.mapper.IJobSeekerPersistenceMapper;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import com.exaucet.joblessito.common.annotation.PersistenceAdapter;
import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.IGetAllJobSeekerPort;
import com.exaucet.joblessito.persistence.mssql.adapter.parent.AbstractGetAllJpaAdapter;
import com.exaucet.joblessito.persistence.mssql.repository.IJobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

@SuppressWarnings("unchecked")
@PersistenceAdapter
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class GetAllJobSeekerPersistenceAdapter extends AbstractGetAllJpaAdapter implements IGetAllJobSeekerPort {

    private final IJobSeekerRepository repository;

    @Setter(onMethod_ = @Autowired)
    private IJobSeekerPersistenceMapper mapper;

    @Override
    public Optional<Set<JobSeeker>> handle() {
        return getAll();
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
