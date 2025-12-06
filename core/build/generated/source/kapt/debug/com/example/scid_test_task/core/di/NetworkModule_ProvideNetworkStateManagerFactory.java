package com.example.scid_test_task.core.di;

import com.example.scid_test_task.core.network.NetworkMonitor;
import com.example.scid_test_task.core.network.NetworkStateManager;
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
public final class NetworkModule_ProvideNetworkStateManagerFactory implements Factory<NetworkStateManager> {
  private final Provider<NetworkMonitor> networkMonitorProvider;

  private NetworkModule_ProvideNetworkStateManagerFactory(
      Provider<NetworkMonitor> networkMonitorProvider) {
    this.networkMonitorProvider = networkMonitorProvider;
  }

  @Override
  public NetworkStateManager get() {
    return provideNetworkStateManager(networkMonitorProvider.get());
  }

  public static NetworkModule_ProvideNetworkStateManagerFactory create(
      Provider<NetworkMonitor> networkMonitorProvider) {
    return new NetworkModule_ProvideNetworkStateManagerFactory(networkMonitorProvider);
  }

  public static NetworkStateManager provideNetworkStateManager(NetworkMonitor networkMonitor) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideNetworkStateManager(networkMonitor));
  }
}
