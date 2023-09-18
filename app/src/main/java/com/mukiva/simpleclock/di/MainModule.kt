package com.mukiva.simpleclock.di

import com.mukiva.simpleclock.presentation.MainState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class MainModule {

    @Provides
    fun provideMainState() = MainState.default()

}