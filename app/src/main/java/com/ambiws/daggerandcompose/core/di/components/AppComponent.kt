package com.ambiws.daggerandcompose.core.di.components

import com.ambiws.daggerandcompose.core.di.factory.ViewModelFactory
import com.ambiws.daggerandcompose.core.di.modules.AppBindsModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppBindsModule::class])
@Singleton
interface AppComponent {

    val factory: ViewModelFactory

    val viewModelComponent: ViewModelComponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}
