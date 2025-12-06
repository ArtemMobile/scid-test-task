package com.example.scid_test_task.data.repository;

import com.example.scid_test_task.core.network.NetworkStateManager;
import com.example.scid_test_task.data.local.dao.ProductDao;
import com.example.scid_test_task.data.local.database.AppDatabase;
import com.example.scid_test_task.data.remote.api.FakeStoreApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class ProductRepositoryImpl_Factory implements Factory<ProductRepositoryImpl> {
  private final Provider<FakeStoreApi> apiProvider;

  private final Provider<AppDatabase> databaseProvider;

  private final Provider<ProductDao> productDaoProvider;

  private final Provider<NetworkStateManager> networkStateManagerProvider;

  private ProductRepositoryImpl_Factory(Provider<FakeStoreApi> apiProvider,
      Provider<AppDatabase> databaseProvider, Provider<ProductDao> productDaoProvider,
      Provider<NetworkStateManager> networkStateManagerProvider) {
    this.apiProvider = apiProvider;
    this.databaseProvider = databaseProvider;
    this.productDaoProvider = productDaoProvider;
    this.networkStateManagerProvider = networkStateManagerProvider;
  }

  @Override
  public ProductRepositoryImpl get() {
    return newInstance(apiProvider.get(), databaseProvider.get(), productDaoProvider.get(), networkStateManagerProvider.get());
  }

  public static ProductRepositoryImpl_Factory create(Provider<FakeStoreApi> apiProvider,
      Provider<AppDatabase> databaseProvider, Provider<ProductDao> productDaoProvider,
      Provider<NetworkStateManager> networkStateManagerProvider) {
    return new ProductRepositoryImpl_Factory(apiProvider, databaseProvider, productDaoProvider, networkStateManagerProvider);
  }

  public static ProductRepositoryImpl newInstance(FakeStoreApi api, AppDatabase database,
      ProductDao productDao, NetworkStateManager networkStateManager) {
    return new ProductRepositoryImpl(api, database, productDao, networkStateManager);
  }
}
