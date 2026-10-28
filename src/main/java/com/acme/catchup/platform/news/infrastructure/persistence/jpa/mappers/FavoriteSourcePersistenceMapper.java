package com.acme.catchup.platform.news.infrastructure.persistence.jpa.mappers;

import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.model.valueobjects.*;
import com.acme.catchup.platform.news.infrastructure.persistence.jpa.entities.FavoriteSourceJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class FavoriteSourcePersistenceMapper {
    public FavoriteSourceJpaEntity toEntity(FavoriteSource source) {
        return new FavoriteSourceJpaEntity(source.getId(), source.getNewsApiKey().value(), source.getSourceId().value(), source.getCreatedAt(), source.getUpdatedAt());
    }

    public FavoriteSource toDomain(FavoriteSourceJpaEntity entity) {
        return FavoriteSource.rehydrate(entity.getId(), new NewsApiKey(entity.getNewsApiKey()), new SourceId(entity.getSourceId()), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
