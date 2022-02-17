package com.example.podlodkadota.models

import androidx.annotation.DrawableRes

data class GameMediaPreview(
    val gameMediaPreviewType: GameMediaPreviewType,
    @DrawableRes val gameMediaPreviewThumbImage: Int
)