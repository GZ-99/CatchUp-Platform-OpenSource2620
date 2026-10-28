package com.acme.catchup.platform.news.infrastructure.persistence.jpa.adapters;

import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.model.valueobjects.*;
import com.acme.catchup.platform.news.domain.exceptions.DuplicateFavoriteSourceException;
import com.acme.catchup.platform.news.domain.repositories.FavoriteSourceRepository;
import com.acme.catchup.platform.news.infrastructure.persistence.jpa.mappers.FavoriteSourcePersistenceMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FavoriteSourceRepositoryAdapter implements FavoriteSourceRepository {
    private final com.acme.catchup.platform.news.infrastructure.persistence.jpa.FavoriteSourceRepository jpa;
    private final FavoriteSourcePersistenceMapper mapper;

    public FavoriteSourceRepositoryAdapter(com.acme.catchup.platform.news.infrastructure.persistence.jpa.FavoriteSourceRepository jpa, FavoriteSourcePersistenceMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    public FavoriteSource save(FavoriteSource favorite) {
        return mapper.toDomain(
                jpa.saveAndFlush(mapper.toEntity(favorite))
        );
    }

    public boolean existsByNewsApiKeyAndSourceId(NewsApiKey key, SourceId source) {
        return jpa.existsByNewsApiKeyAndSourceId(key.value(), source.value());
    }

    public Optional<FavoriteSource> findById(Long id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    public Optional<FavoriteSource> findByNewsApiKeyAndSourceId(NewsApiKey key, SourceId source) {
        return jpa.findByNewsApiKeyAndSourceId(key.value(), source.value()).map(mapper::toDomain);
    }

    public List<FavoriteSource> findAllByNewsApiKey(NewsApiKey key) {
        return jpa.findAllByNewsApiKey(key.value()).stream().map(mapper::toDomain).toList();
    }
}
