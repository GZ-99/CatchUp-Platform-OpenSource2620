package com.acme.catchup.platform.news.application.internal.commandservices;

import com.acme.catchup.platform.news.application.commandservices.*;
import com.acme.catchup.platform.news.application.commands.CreateFavoriteSourceCommand;
import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import com.acme.catchup.platform.news.domain.repositories.FavoriteSourceRepository;
import com.acme.catchup.platform.news.domain.exceptions.DuplicateFavoriteSourceException;
import com.acme.catchup.platform.shared.application.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;

@Service
public class FavoriteSourceCommandServiceImpl implements FavoriteSourceCommandService {
    private final FavoriteSourceRepository repository;
    private final Clock clock;

    public FavoriteSourceCommandServiceImpl(FavoriteSourceRepository repository, Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

    @Override
    @Transactional
    public Result<FavoriteSource, FavoriteSourceCommandFailure> handle(CreateFavoriteSourceCommand command) {
        if (repository.existsByNewsApiKeyAndSourceId(command.newsApiKey(), command.sourceId()))
            return Result.failure(new FavoriteSourceCommandFailure.Duplicate());
        try {
            return Result.success(repository.save(FavoriteSource.create(command.newsApiKey(), command.sourceId(), clock.instant())));
        } catch (DuplicateFavoriteSourceException e) {
            return Result.failure(new FavoriteSourceCommandFailure.Duplicate());
        }
    }
}
