package com.exaucet.joblessito.persistence.mssql.adapter.parent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;

import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

@SuppressWarnings("unchecked, rawTypes")
public abstract class AbstractGetAllJpaAdapter extends AbstractJpaAdapter<CrudRepository> {

    @Transactional(readOnly = true)
    protected <T> Optional<Set<T>> getAll() {

        Iterable entities = getRepository().findAll();

        Set<T> result = (Set<T>) stream(spliteratorUnknownSize(entities.iterator(), Spliterator.ORDERED), true)
                .map(getMapper()::entityToModel)
                .collect(Collectors.toSet());

        return Optional.of(result);
    }
}
