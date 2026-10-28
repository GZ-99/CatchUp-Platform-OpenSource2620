# Interface mapper naming and OpenAPI configuration

The five classes under `news/interfaces/rest/transform` were renamed:

- `CreateFavoriteSourceCommandFromResourceAssembler` -> `CreateFavoriteSourceCommandMapper`
- `NewsValueObjectFromStringAssembler` -> `NewsValueObjectMapper`
- `FavoriteSourceResourceFromEntityAssembler` -> `FavoriteSourceResourceMapper`
- `ResponseEntityFromFavoriteSourceCommandResultAssembler` -> `FavoriteSourceCommandHttpResponseMapper`
- `ResponseEntityFromFavoriteSourceQueryResultAssembler` -> `FavoriteSourceQueryHttpResponseMapper`

All Java references (including unit tests) were updated. Public method names and HTTP behavior are unchanged.

Shared OpenAPI metadata is configured in `shared/infrastructure/configuration/openapi/OpenApiConfig.java`.
Existing endpoint-level `@Operation`, `@ApiResponses`, and resource `@Schema` annotations remain in place.

After starting Spring Boot, visit `/swagger-ui/index.html` or `/v3/api-docs` (unless overridden by application configuration).
