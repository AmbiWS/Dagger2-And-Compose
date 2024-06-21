package com.ambiws.daggerandcompose.core.di.modules

import androidx.lifecycle.ViewModel
import com.ambiws.daggerandcompose.core.di.vm.ViewModelKey
import com.ambiws.daggerandcompose.features.home.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}
