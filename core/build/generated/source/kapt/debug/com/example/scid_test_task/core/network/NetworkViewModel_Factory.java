package com.example.scid_test_task.core.network;

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
public final class NetworkViewModel_Factory implements Factory<NetworkViewModel> {
  private final Provider<NetworkStateManager> networkStateManagerProvider;

  private NetworkViewModel_Factory(Provider<NetworkStateManager> networkStateManagerProvider) {
    this.networkStateManagerProvider = networkStateManagerProvider;
  }

  @Override
  public NetworkViewModel get() {
    return newInstance(networkStateManagerProvider.get());
  }

  public static NetworkViewModel_Factory create(
      Provider<NetworkStateManager> networkStateManagerProvider) {
    return new NetworkViewModel_Factory(networkStateManagerProvider);
  }

  public static NetworkViewModel newInstance(NetworkStateManager networkStateManager) {
    return new NetworkViewModel(networkStateManager);
  }
}
