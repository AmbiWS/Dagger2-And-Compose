package com.ambiws.daggerandcompose.utils.extensions

val <T : Any> T.className: String
    get() = this::class.java.simpleName
