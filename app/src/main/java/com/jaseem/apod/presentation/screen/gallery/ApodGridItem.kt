package com.jaseem.apod.presentation.screen.gallery

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Visibility
import coil.compose.AsyncImage
import com.jaseem.apod.presentation.ui.component.TextOverlayGradientBg

@Composable
fun ApodGridItem(
    title: String,
    imageUrl: String,
    copyright: String?,
    modifier: Modifier
) {
    ConstraintLayout(modifier = modifier) {
        val (imageBg, textTitle, textCopyright, overlayTextBg) = createRefs()

        AsyncImage(
            model = imageUrl,
            contentDescription = "Image: $title",
            contentScale = ContentScale.Crop,
            modifier = Modifier.constrainAs(imageBg) {
                width = Dimension.matchParent
                height = Dimension.matchParent
            }
        )

        TextOverlayGradientBg(
            modifier = Modifier.constrainAs(overlayTextBg) {
                linkTo(start = parent.start, end = parent.end)
                linkTo(top = textTitle.top, bottom = parent.bottom)

                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(textTitle) {
                    linkTo(start = parent.start, end = parent.end)
                    bottom.linkTo(textCopyright.top, 8.dp, 8.dp)

                    width = Dimension.matchParent
                }
                .padding(top = 12.dp)
                .padding(horizontal = 14.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = copyright ?: "",
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(textCopyright) {
                    linkTo(start = parent.start, end = parent.end)
                    bottom.linkTo(parent.bottom)

                    width = Dimension.matchParent

                    visibility = if (copyright.isNullOrEmpty()) {
                        Visibility.Gone
                    } else {
                        Visibility.Visible
                    }
                }
                .padding(bottom = 12.dp)
                .padding(horizontal = 14.dp)
        )
    }
}