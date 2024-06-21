package com.ambiws.daggerandcompose.core.di.vm

import com.ambiws.daggerandcompose.base.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out BaseViewModel>)
