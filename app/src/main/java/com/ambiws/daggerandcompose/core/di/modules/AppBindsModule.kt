package com.ambiws.daggerandcompose.core.di.modules

import com.ambiws.daggerandcompose.MainViewModel
import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.core.di.components.ViewModelComponent
import com.ambiws.daggerandcompose.core.di.vm.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [ViewModelComponent::class])
interface AppBindsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(mainViewModel: MainViewModel): BaseViewModel
}
