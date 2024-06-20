package com.ambiws.daggerandcompose.core.di.component

import com.ambiws.daggerandcompose.MainActivity
import com.ambiws.daggerandcompose.core.di.module.AppModule
import com.ambiws.daggerandcompose.core.di.module.NetModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface NetComponent {
    fun inject(activity: MainActivity)
}
