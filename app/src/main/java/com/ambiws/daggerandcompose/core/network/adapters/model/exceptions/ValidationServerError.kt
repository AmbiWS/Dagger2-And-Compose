package com.ambiws.daggerandcompose.core.network.adapters.model.exceptions

import com.ambiws.daggerandcompose.core.network.adapters.model.StatusCode
import com.ambiws.daggerandcompose.core.network.adapters.model.exceptions.ServerError

class ValidationServerError(
    override val message: String,
    cause: Throwable,
    errorsList: List<String>? = null
) : ServerError(
    message = message,
    code = StatusCode.VALIDATION.code,
    cause = cause,
    errorsList = errorsList
)
