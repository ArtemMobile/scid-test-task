package com.example.scid_test_task.core.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class NetworkStateManager_Factory implements Factory<NetworkStateManager> {
  private final Provider<NetworkMonitor> networkMonitorProvider;

  private NetworkStateManager_Factory(Provider<NetworkMonitor> networkMonitorProvider) {
    this.networkMonitorProvider = networkMonitorProvider;
  }

  @Override
  public NetworkStateManager get() {
    return newInstance(networkMonitorProvider.get());
  }

  public static NetworkStateManager_Factory create(
      Provider<NetworkMonitor> networkMonitorProvider) {
    return new NetworkStateManager_Factory(networkMonitorProvider);
  }

  public static NetworkStateManager newInstance(NetworkMonitor networkMonitor) {
    return new NetworkStateManager(networkMonitor);
  }
}
