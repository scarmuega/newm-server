package io.projectnewm.server.user

import io.projectnewm.server.auth.oauth.OAuthType
import io.projectnewm.server.serialization.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class User(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID? = null,
    val oauthType: OAuthType? = null,
    val oauthId: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val pictureUrl: String? = null,
    val email: String? = null,
    val newPassword: Password? = null,
    val confirmPassword: Password? = null,
    val currentPassword: Password? = null,
    val authCode: String? = null
)
