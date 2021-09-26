package com.exaucet.joblessito.persistence.mssql.adapter.parent.mapper;

public interface IGenericMapper<M, E> {

    M entityToModel(E entity);
}
