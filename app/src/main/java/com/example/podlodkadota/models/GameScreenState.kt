package com.example.podlodkadota.models

import androidx.annotation.DrawableRes

data class GameScreenState(
    @DrawableRes val gameHeaderImage: Int,
    @DrawableRes val gameIconImage: Int,
    val gameName: String,
    val gamePublicRating: Double,
    val gameReviewsCount: String,
    val gameTagsList: List<String>,
    val gameDescription: String,
    val gameMediaPreviewsList: List<GameMediaPreview>,
    val gameUsersReviewsList: List<GameUserReview>
)
