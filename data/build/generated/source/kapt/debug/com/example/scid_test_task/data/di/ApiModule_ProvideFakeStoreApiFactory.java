package com.example.scid_test_task.data.di;

import com.example.scid_test_task.data.remote.api.FakeStoreApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

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
public final class ApiModule_ProvideFakeStoreApiFactory implements Factory<FakeStoreApi> {
  private final Provider<Retrofit> retrofitProvider;

  private ApiModule_ProvideFakeStoreApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public FakeStoreApi get() {
    return provideFakeStoreApi(retrofitProvider.get());
  }

  public static ApiModule_ProvideFakeStoreApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideFakeStoreApiFactory(retrofitProvider);
  }

  public static FakeStoreApi provideFakeStoreApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.provideFakeStoreApi(retrofit));
  }
}
