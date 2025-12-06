package com.example.scid_test_task.data.di;

import com.example.scid_test_task.core.network.NetworkStateManager;
import com.example.scid_test_task.data.local.dao.ProductDao;
import com.example.scid_test_task.data.local.database.AppDatabase;
import com.example.scid_test_task.data.remote.api.FakeStoreApi;
import com.example.scid_test_task.domain.repository.ProductRepository;
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
public final class RepositoryModule_ProvideProductRepositoryFactory implements Factory<ProductRepository> {
  private final Provider<FakeStoreApi> apiProvider;

  private final Provider<AppDatabase> databaseProvider;

  private final Provider<ProductDao> productDaoProvider;

  private final Provider<NetworkStateManager> networkStateManagerProvider;

  private RepositoryModule_ProvideProductRepositoryFactory(Provider<FakeStoreApi> apiProvider,
      Provider<AppDatabase> databaseProvider, Provider<ProductDao> productDaoProvider,
      Provider<NetworkStateManager> networkStateManagerProvider) {
    this.apiProvider = apiProvider;
    this.databaseProvider = databaseProvider;
    this.productDaoProvider = productDaoProvider;
    this.networkStateManagerProvider = networkStateManagerProvider;
  }

  @Override
  public ProductRepository get() {
    return provideProductRepository(apiProvider.get(), databaseProvider.get(), productDaoProvider.get(), networkStateManagerProvider.get());
  }

  public static RepositoryModule_ProvideProductRepositoryFactory create(
      Provider<FakeStoreApi> apiProvider, Provider<AppDatabase> databaseProvider,
      Provider<ProductDao> productDaoProvider,
      Provider<NetworkStateManager> networkStateManagerProvider) {
    return new RepositoryModule_ProvideProductRepositoryFactory(apiProvider, databaseProvider, productDaoProvider, networkStateManagerProvider);
  }

  public static ProductRepository provideProductRepository(FakeStoreApi api, AppDatabase database,
      ProductDao productDao, NetworkStateManager networkStateManager) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideProductRepository(api, database, productDao, networkStateManager));
  }
}
