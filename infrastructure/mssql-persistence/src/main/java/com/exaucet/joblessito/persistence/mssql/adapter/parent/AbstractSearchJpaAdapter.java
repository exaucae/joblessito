package com.exaucet.joblessito.persistence.mssql.adapter.parent;

import com.sipios.springsearch.SpecificationsBuilder;
import com.sipios.springsearch.anotation.SearchSpec;
import io.leangen.geantyref.TypeFactory;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Spliterators.spliteratorUnknownSize;

@SuppressWarnings("unchecked, rawtypes")
public abstract class AbstractSearchJpaAdapter extends AbstractJpaAdapter<JpaSpecificationExecutor> {


    @Transactional(readOnly = true)
    protected <T> Optional<Set<T>> search(String query) {
        Iterable entities = getRepository().findAll(buildQuerySpecification(query));
        Set<T> result = mapEntityToModel(entities);
        return Optional.of(result);
    }

    protected <T> Set<T> mapEntityToModel(Iterable entities) {
        return (Set<T>) StreamSupport
                .stream(spliteratorUnknownSize(entities.iterator(), Spliterator.ORDERED), true)
                .map(getMapper()::entityToModel)
                .collect(Collectors.toSet());
    }

    @SneakyThrows
    protected <T> Specification<T> buildQuerySpecification(String query) {

        SearchSpec annotation = TypeFactory.annotation(SearchSpec.class, Collections.singletonMap("caseSensitiveFlag", false));
        return new SpecificationsBuilder<T>(Objects.requireNonNull(annotation))
                .withSearch(query)
                .build();
    }
}