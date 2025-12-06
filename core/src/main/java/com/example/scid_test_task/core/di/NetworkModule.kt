package com.example.scid_test_task.core.di

import android.content.Context
import com.example.scid_test_task.core.network.NetworkMonitor
import com.example.scid_test_task.core.network.NetworkStateManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkMonitor(@ApplicationContext context: Context): NetworkMonitor {
        return NetworkMonitor(context)
    }

    @Provides
    @Singleton
    fun provideNetworkStateManager(networkMonitor: NetworkMonitor): NetworkStateManager {
        return NetworkStateManager(networkMonitor)
    }
}



