package com.jaseem.apod.presentation.screen.details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jaseem.apod.R
import com.jaseem.apod.presentation.ui.component.TextOverlayGradientBg

@Composable
fun DetailsScreen(
    onClickBack: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (
            iconBack,
            textTitle,
            imageCosmos,
            textCopyright,
            textDate,
            textExplanation,
            bgOverlayText,
            bgExplanation
        ) = createRefs()

        val uiState = viewModel.uiState

        Log.d("DebugExplanation", "DetailsScreen: ${uiState.explanation}")
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back Icon",
            tint = Color.White,
            modifier = Modifier
                .constrainAs(iconBack) {
                    top.linkTo(parent.top, 8.dp)
                    start.linkTo(parent.start, 16.dp)

                    width = Dimension.value(42.dp)
                    height = Dimension.value(42.dp)
                }
                .clip(CircleShape)
                .clickable {
                    onClickBack()
                }
                .padding(8.dp)
        )

        Text(
            text = uiState.title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.constrainAs(textTitle) {
                linkTo(start = iconBack.end, end = parent.end, endMargin = 24.dp)
                centerVerticallyTo(iconBack)

                width = Dimension.fillToConstraints
            }
        )

        AsyncImage(
            model = uiState.imageUrl,
            contentDescription = "${uiState.title} Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(imageCosmos) {
                    top.linkTo(textTitle.bottom, 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width = Dimension.matchParent
                    height = Dimension.ratio("1:1")
                }
        )

        TextOverlayGradientBg(
            modifier = Modifier.constrainAs(bgOverlayText) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(textDate.top, (-16).dp)
                bottom.linkTo(textExplanation.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
        )

        Text(
            text = uiState.copyright,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.constrainAs(textCopyright) {
                start.linkTo(parent.start, 22.dp)
                bottom.linkTo(bgExplanation.top, 10.dp)
            }
        )

        Text(
            text = uiState.date,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.constrainAs(textDate) {
                end.linkTo(parent.end, 22.dp)
                bottom.linkTo(bgExplanation.top, 10.dp)
            }
        )

        Box(
            modifier = Modifier
                .constrainAs(bgExplanation) {
                    linkTo(top = imageCosmos.bottom, bottom = parent.bottom, topMargin = (-16).dp)
                    linkTo(start = parent.start, end = parent.end)

                    width = Dimension.matchParent
                    height = Dimension.fillToConstraints
                }
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp)
                )
        )

        Text(
            text = uiState.explanation,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .constrainAs(textExplanation) {
                    linkTo(top = bgExplanation.top, bottom = parent.bottom, topMargin = 22.dp)
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        startMargin = 22.dp,
                        endMargin = 22.dp
                    )

                    width = Dimension.matchParent
                    height = Dimension.fillToConstraints
                }
                .zIndex(2f)
        )
    }
}