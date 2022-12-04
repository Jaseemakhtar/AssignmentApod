package com.jaseem.apod.presentation.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.jaseem.apod.R
import com.jaseem.apod.domain.Cosmos
import com.jaseem.apod.presentation.ui.component.TextOverlayGradientBg
import com.jaseem.apod.presentation.ui.theme.EbonyClay500

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailsScreen(
    currentPageId: Int,
    cosmosList: List<Cosmos>,
    onClickClose: () -> Unit
) {
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxSize()) {
        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_close),
            contentDescription = stringResource(id = R.string.accessibility_close_details),
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .background(EbonyClay500)
                .padding(top = 8.dp, start = 16.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(radius = 24.dp, bounded = false)
                ) {
                    onClickClose()
                }
                .size(42.dp)
                .padding(8.dp)
                .zIndex(2f)
        )

        HorizontalPager(
            state = pagerState,
            count = cosmosList.size,
            modifier = Modifier.fillMaxSize()
        ) { currentPage ->
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (
                    textTitle,
                    imageCosmos,
                    textCopyright,
                    textDate,
                    textExplanation,
                    bgOverlayText,
                    bgExplanation
                ) = createRefs()

                val item = cosmosList[currentPage]


                Text(
                    text = item.title,
                    style = MaterialTheme.typography.headlineSmall, maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.constrainAs(textTitle) {

                        top.linkTo(parent.top, 12.dp)

                        linkTo(
                            start = parent.start,
                            end = parent.end,
                            startMargin = 64.dp,
                            endMargin = 24.dp
                        )

                        width = Dimension.fillToConstraints
                    }
                )

                AsyncImage(
                    model = item.url,
                    contentDescription = "${item.title} Image",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.img_loading),
                    error = painterResource(id = R.drawable.img_no_image),
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
                    text = item.copyright,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.constrainAs(textCopyright) {
                        start.linkTo(parent.start, 22.dp)
                        bottom.linkTo(bgExplanation.top, 10.dp)
                    }
                )

                Text(
                    text = item.date,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.constrainAs(textDate) {
                        end.linkTo(parent.end, 22.dp)
                        bottom.linkTo(bgExplanation.top, 10.dp)
                    }
                )

                Box(
                    modifier = Modifier
                        .constrainAs(bgExplanation) {
                            linkTo(
                                top = imageCosmos.bottom,
                                bottom = parent.bottom,
                                topMargin = (-16).dp
                            )
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
                    text = item.explanation,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .constrainAs(textExplanation) {
                            linkTo(
                                top = bgExplanation.top,
                                bottom = parent.bottom,
                                topMargin = 22.dp
                            )
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
    }

    LaunchedEffect(currentPageId) {
        if (pagerState.pageCount != 0) {
            pagerState.animateScrollToPage(currentPageId)
        }
    }
}