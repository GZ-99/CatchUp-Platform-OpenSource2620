package com.acme.catchup.platform.news.application.internal.queryservices;

import com.acme.catchup.platform.news.application.queryservices.FavoriteSourceQueryService;
import com.acme.catchup.platform.news.application.queries.*;
import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.repositories.FavoriteSourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class FavoriteSourceQueryServiceImpl implements FavoriteSourceQueryService {
    private final FavoriteSourceRepository repository;

    public FavoriteSourceQueryServiceImpl(FavoriteSourceRepository repository) {
        this.repository = repository;
    }

    public List<FavoriteSource> handle(GetAllFavoriteSourcesByNewsApiKeyQuery q) {
        return repository.findAllByNewsApiKey(q.newsApiKey());
    }

    public Optional<FavoriteSource> handle(GetFavoriteSourceByIdQuery q) {

        return repository.findById(q.id());
    }

    public Optional<FavoriteSource> handle(GetFavoriteSourceByNewsApiKeyAndSourceIdQuery q) {
        return repository.findByNewsApiKeyAndSourceId(q.newsApiKey(), q.sourceId());
    }
}
