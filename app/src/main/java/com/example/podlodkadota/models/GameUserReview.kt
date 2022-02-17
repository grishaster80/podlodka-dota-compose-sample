package com.example.podlodkadota.models

import androidx.annotation.DrawableRes

data class GameUserReview(
    val userName: String,
    val reviewDate: String,
    @DrawableRes val userAvatarThumbImage: Int,
    val reviewText: String
)
