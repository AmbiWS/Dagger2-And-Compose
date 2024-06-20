package com.ambiws.daggerandcompose.core.network.adapters.model.exceptions

import java.io.IOException

class UnexpectedNetworkError(cause: Throwable) : IOException(cause)
