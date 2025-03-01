package io.newm.server.di

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.application.log
import io.newm.server.auth.authKoinModule
import io.newm.server.client.clientKoinModule
import io.newm.server.aws.awsKoinModule
import io.newm.server.features.cloudinary.cloudinaryKoinModule
import io.newm.server.features.playlist.playlistKoinModule
import io.newm.server.features.song.songKoinModule
import io.newm.server.features.user.userKoinModule
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin

fun Application.installDependencyInjection() {
    val appKoinModule = module {
        single { this@installDependencyInjection }
        factory { get<Application>().environment }
        factory { get<Application>().log }
    }
    install(Koin) {
        modules(
            appKoinModule,
            clientKoinModule,
            userKoinModule,
            authKoinModule,
            songKoinModule,
            playlistKoinModule,
            cloudinaryKoinModule,
            awsKoinModule
        )
    }
}
