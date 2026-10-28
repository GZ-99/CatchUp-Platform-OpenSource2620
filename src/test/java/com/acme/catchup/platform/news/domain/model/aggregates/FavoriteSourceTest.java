package com.acme.catchup.platform.news.domain.model.aggregates;
import com.acme.catchup.platform.news.domain.model.valueobjects.*;
import com.acme.catchup.platform.news.domain.model.events.FavoriteSourceCreatedEvent;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;
class FavoriteSourceTest {
 @Test void createsAndDrainsEventOnce(){
  var source=FavoriteSource.create(new NewsApiKey("key"),new SourceId("bbc-news"),Instant.EPOCH);
  assertNull(source.getId()); assertEquals(1,source.pullDomainEvents().size()); assertTrue(source.pullDomainEvents().isEmpty());
 }
 @Test void rehydrationDoesNotEmitEvent(){
  var source=FavoriteSource.rehydrate(1L,new NewsApiKey("key"),new SourceId("bbc-news"),Instant.EPOCH,Instant.EPOCH);
  assertTrue(source.pullDomainEvents().isEmpty());
 }
}
