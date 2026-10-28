package com.acme.catchup.platform.news.domain.repositories;
import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.model.valueobjects.*;
import java.util.*;
/** Technology-independent outbound persistence port. */
public interface FavoriteSourceRepository {
 FavoriteSource save(FavoriteSource favorite);
 boolean existsByNewsApiKeyAndSourceId(NewsApiKey key, SourceId sourceId);
 Optional<FavoriteSource> findById(Long id);
 Optional<FavoriteSource> findByNewsApiKeyAndSourceId(NewsApiKey key, SourceId sourceId);
 List<FavoriteSource> findAllByNewsApiKey(NewsApiKey key);
}
