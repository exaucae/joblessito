package com.exaucet.joblessito.persistence.mssql.adapter.parent;

import com.exaucet.joblessito.persistence.mssql.adapter.parent.mapper.IGenericMapper;

abstract class AbstractJpaAdapter<REPOSITORY> {

    protected abstract <T extends REPOSITORY> T getRepository();

    protected abstract <T extends IGenericMapper> T getMapper();
}
