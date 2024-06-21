package com.ambiws.daggerandcompose.core.di.components

import android.content.Context
import com.ambiws.daggerandcompose.core.di.modules.NetModule
import com.ambiws.daggerandcompose.core.di.factory.ViewModelFactory
import com.ambiws.daggerandcompose.core.di.modules.AppBindsModule
import com.ambiws.daggerandcompose.core.di.modules.UtilsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppBindsModule::class, NetModule::class, UtilsModule::class])
@Singleton
interface AppComponent {

    val factory: ViewModelFactory

    val viewModelComponent: ViewModelComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}
