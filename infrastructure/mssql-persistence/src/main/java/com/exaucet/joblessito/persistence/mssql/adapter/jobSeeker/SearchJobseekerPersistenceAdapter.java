package com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.application.jobSeeker.spi.persistence.ISearchJobSeekerPort;
import com.exaucet.joblessito.common.annotation.PersistenceAdapter;
import com.exaucet.joblessito.persistence.mssql.adapter.jobSeeker.mapper.IJobSeekerPersistenceMapper;
import com.exaucet.joblessito.persistence.mssql.adapter.parent.AbstractGetAllJpaAdapter;
import com.exaucet.joblessito.persistence.mssql.repository.IJobSeekerRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
@PersistenceAdapter
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SearchJobseekerPersistenceAdapter extends AbstractGetAllJpaAdapter implements ISearchJobSeekerPort {

    private final IJobSeekerRepository repository;

    @Setter(onMethod_ = @Autowired)
    private IJobSeekerPersistenceMapper mapper;

    @Override
    protected IJobSeekerRepository getRepository() {
        return repository;
    }

    @Override
    protected IJobSeekerPersistenceMapper getMapper() {
        return mapper;
    }

    @Override
    public Optional<Set<JobSeeker>> handle(Specification<JobSeeker> specs) {
        var res = repository.findAll(Specification.where(mapper.toEntitySpecs(specs)));

        var res2 = res.stream().map(
                seeker -> mapper.entityToModel(seeker)
        ).collect(Collectors.toSet());

        return Optional.of(res2);

    }
}
