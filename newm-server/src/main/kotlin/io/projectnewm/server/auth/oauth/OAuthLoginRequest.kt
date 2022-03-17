package io.projectnewm.server.auth.oauth

import kotlinx.serialization.Serializable

@Serializable
data class OAuthLoginRequest(val accessToken: String)
