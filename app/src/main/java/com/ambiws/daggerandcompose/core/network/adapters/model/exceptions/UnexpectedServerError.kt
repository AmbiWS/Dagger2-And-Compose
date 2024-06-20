package com.ambiws.daggerandcompose.core.network.adapters.model.exceptions

class UnexpectedServerError(code: Int) : ServerError(
    message = "Unexpected server error with code: $code",
    code = code
)
