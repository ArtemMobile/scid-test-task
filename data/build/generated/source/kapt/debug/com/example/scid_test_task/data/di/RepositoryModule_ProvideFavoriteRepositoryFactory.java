package com.example.scid_test_task.data.di;

import com.example.scid_test_task.data.local.dao.FavoriteDao;
import com.example.scid_test_task.domain.repository.FavoriteRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class RepositoryModule_ProvideFavoriteRepositoryFactory implements Factory<FavoriteRepository> {
  private final Provider<FavoriteDao> favoriteDaoProvider;

  private RepositoryModule_ProvideFavoriteRepositoryFactory(
      Provider<FavoriteDao> favoriteDaoProvider) {
    this.favoriteDaoProvider = favoriteDaoProvider;
  }

  @Override
  public FavoriteRepository get() {
    return provideFavoriteRepository(favoriteDaoProvider.get());
  }

  public static RepositoryModule_ProvideFavoriteRepositoryFactory create(
      Provider<FavoriteDao> favoriteDaoProvider) {
    return new RepositoryModule_ProvideFavoriteRepositoryFactory(favoriteDaoProvider);
  }

  public static FavoriteRepository provideFavoriteRepository(FavoriteDao favoriteDao) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideFavoriteRepository(favoriteDao));
  }
}
