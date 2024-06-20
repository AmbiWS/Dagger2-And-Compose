package com.ambiws.daggerandcompose.core.network.adapters.model.exceptions

import com.ambiws.daggerandcompose.core.network.adapters.model.StatusCode
import com.ambiws.daggerandcompose.core.network.adapters.model.exceptions.ServerError

class UnauthorizedServerError(
    override val message: String,
    cause: Throwable
) : ServerError(
    message = message,
    code = StatusCode.UNAUTHORIZED.code,
    cause = cause
)
