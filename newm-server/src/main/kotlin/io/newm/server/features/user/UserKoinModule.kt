package io.newm.server.features.user

import io.newm.server.features.user.oauth.providers.FacebookUserProvider
import io.newm.server.features.user.oauth.providers.GoogleUserProvider
import io.newm.server.features.user.oauth.providers.LinkedInUserProvider
import io.newm.server.features.user.repo.UserRepository
import io.newm.server.features.user.repo.UserRepositoryImpl
import org.koin.dsl.module

val userKoinModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get(), get(), get(), get()) }
    single { GoogleUserProvider(get()) }
    single { FacebookUserProvider(get()) }
    single { LinkedInUserProvider(get()) }
}
