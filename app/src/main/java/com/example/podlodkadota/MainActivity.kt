package com.example.podlodkadota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.podlodkadota.models.GameMediaPreview
import com.example.podlodkadota.models.GameMediaPreviewType
import com.example.podlodkadota.models.GameScreenState
import com.example.podlodkadota.models.GameUserReview
import com.example.podlodkadota.ui.theme.PodlodkaDotaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaDotaTheme {
                val gameScreenData = GameScreenState(
                    gameHeaderImage = R.drawable.dota_header_img,
                    gameIconImage = R.drawable.dota_logo_image,
                    gameName = "DoTA2",
                    gamePublicRating = 4.9,
                    gameReviewsCount = "70M",
                    gameTagsList = listOf("MOBA", "MULTIPLAYER", "STRATEGY"),
                    gameDescription = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
                    gameMediaPreviewsList = listOf(
                        GameMediaPreview(
                            gameMediaPreviewType = GameMediaPreviewType.VIDEO,
                            gameMediaPreviewThumbImage = R.drawable.preview_thumb_1
                        ),
                        GameMediaPreview(
                            gameMediaPreviewType = GameMediaPreviewType.IMAGE,
                            gameMediaPreviewThumbImage = R.drawable.preview_thumb_2
                        )
                    ),
                    gameUsersReviewsList = listOf(
                        GameUserReview(
                            userName = "Auguste Conte",
                            reviewDate = "February 14, 2019",
                            userAvatarThumbImage = R.drawable.preview_user_1,
                            reviewText = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
                        ),
                        GameUserReview(
                            userName = "Jang Marcelino",
                            reviewDate = "February 14, 2019",
                            userAvatarThumbImage = R.drawable.preview_user_2,
                            reviewText = "“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”"
                        )
                    )
                )
                
                
                // A surface container using the 'background' color from the theme
                GameScreen(userData = gameScreenData)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PodlodkaDotaTheme {
        Greeting("Android")
    }
}