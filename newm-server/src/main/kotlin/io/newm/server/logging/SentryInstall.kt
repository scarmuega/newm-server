package io.newm.server.logging

import io.ktor.server.application.Application
import io.newm.server.ext.getConfigString
import io.sentry.Sentry

fun Application.initializeSentry() {
    Sentry.init { options ->
        options.dsn = environment.getConfigString("sentry.dns")
//        options.tracesSampleRate = if (environment.developmentMode) 1.0 else 0.5
        options.tracesSampleRate = 1.0
        options.isDebug = environment.developmentMode
    }
}

internal fun Throwable.captureToSentry() {
    Sentry.captureException(this)
}
