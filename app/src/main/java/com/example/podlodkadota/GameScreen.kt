package com.example.podlodkadota

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.podlodkadota.models.GameScreenState
import com.example.podlodkadota.ui.theme.GameScreenBackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(userData: GameScreenState) {
    val scrollState = rememberScrollState()
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(color = GameScreenBackgroundColor)
    ) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    GameHeader(
                        scrollState,
                        userData,
                        this@BoxWithConstraints.maxHeight
                    )
                    //UserInfoFields(userData, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GameHeader(
    scrollState: ScrollState,
    data: GameScreenState,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }
    ConstraintLayout() {
        val (backButtonConstraint,
            moreButtonConstraint,
            gameHeaderImageConstraint,
            gameIconConstraint,
            gameTitleConstraint,
            gameRatingConstraint,
            gameUserCountConstraint) = createRefs()
        //header img
        Image(
            modifier = Modifier
                .heightIn(max = containerHeight / 2)
                .fillMaxWidth()
                .constrainAs(gameHeaderImageConstraint) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            painter = painterResource(id = data.gameHeaderImage),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        //back button
        Box(modifier = Modifier
            .constrainAs(backButtonConstraint) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(parent.top, 50.dp)
            }
            .clip(CircleShape)) {
            Image(
                painter = painterResource(R.drawable.ic_back_button),
                contentDescription = null,
                Modifier
                    .background(Color(0x80FFFFFF))
                    .padding(16.dp)
            )
        }

        //more button
        Box(modifier = Modifier
            .constrainAs(moreButtonConstraint) {
                end.linkTo(parent.end, 24.dp)
                top.linkTo(parent.top, 50.dp)
            }
            .clip(CircleShape)) {
            Image(
                painter = painterResource(R.drawable.ic_more_square),
                contentDescription = null,
                Modifier
                    .background(Color(0x80FFFFFF))
                    .padding(horizontal = 19.dp, vertical = 26.dp)
            )
        }

        //logo
        Box(modifier = Modifier
            .constrainAs(gameIconConstraint) {
                start.linkTo(backButtonConstraint.start)
                top.linkTo(backButtonConstraint.bottom, 150.dp)
            }
            .clip(RoundedCornerShape(14.dp))
        ) {
            Image(
                painter = painterResource(data.gameIconImage),
                contentDescription = null,
                Modifier
                    .background(Color.Black)
                    .padding(15.dp)
            )
        }

        //game title
        Text(
            // Название игры
            modifier = Modifier
                .constrainAs(gameTitleConstraint) {
                    start.linkTo(gameIconConstraint.end, margin = 12.dp)
                    top.linkTo(gameIconConstraint.top)
                    bottom.linkTo(gameIconConstraint.bottom)
                },
            text = data.gameName,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
        )


    }
}