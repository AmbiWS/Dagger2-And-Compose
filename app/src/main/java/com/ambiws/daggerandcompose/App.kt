package com.ambiws.daggerandcompose

import android.app.Application
import com.ambiws.daggerandcompose.core.di.components.AppComponent
import com.ambiws.daggerandcompose.core.di.components.DaggerAppComponent

// TODO Handle contexts in di graph
// TODO Analyze and optimize scopes (object leaks and creation flow)
// TODO Implement caching feature (lists & room)
// TODO Optimize DI graph
// TODO Check VM recreation cases
// TODO Migrate on Hilt at the latest stage
class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}
