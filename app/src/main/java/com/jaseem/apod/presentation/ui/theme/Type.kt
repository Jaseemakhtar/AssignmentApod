package com.jaseem.apod.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jaseem.apod.R

//@OptIn(ExperimentalTextApi::class)
//val provider = GoogleFont.Provider(
//    providerAuthority = "com.google.android.gms.fonts",
//    providerPackage = "com.google.android.gms",
//    certificates = R.array.com_google_android_gms_fonts_certs
//)

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold)
)

val JockeyOne = FontFamily(
    Font(R.font.jockey, FontWeight.Normal)
)

val AppTypography = Typography(
    headlineLarge = TextStyle(
        color = Color.White,
        fontSize = 38.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = JockeyOne
    ),
    headlineMedium = TextStyle(
        color = Color.White.copy(alpha = 0.6f),
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = JockeyOne
    ),
    titleLarge = TextStyle(
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = Poppins
    ),
    titleMedium = TextStyle(
        color = Color.White,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Poppins
    ),
    bodyMedium = TextStyle(
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Poppins
    ),
    labelSmall = TextStyle(
        color = Color.White,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Poppins
    )
)
