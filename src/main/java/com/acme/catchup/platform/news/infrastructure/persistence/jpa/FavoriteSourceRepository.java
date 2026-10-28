package com.acme.catchup.platform.news.infrastructure.persistence.jpa;

import com.acme.catchup.platform.news.infrastructure.persistence.jpa.entities.FavoriteSourceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/**
 * Spring Data detail, deliberately not a domain port.
 */
public interface FavoriteSourceRepository extends JpaRepository<FavoriteSourceJpaEntity, Long> {
    boolean existsByNewsApiKeyAndSourceId(String key, String sourceId);

    Optional<FavoriteSourceJpaEntity> findByNewsApiKeyAndSourceId(String key, String sourceId);

    List<FavoriteSourceJpaEntity> findAllByNewsApiKey(String key);
}
