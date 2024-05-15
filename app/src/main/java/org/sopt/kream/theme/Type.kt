package org.sopt.kream.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.kream.R

// Set of Material typography styles to start with
val Typography =
    Typography(
        bodyLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
    )

// Head
val head1Bold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    )
val head2Bold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
    )

// Body1
val body1 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
    )

// Body2
val body2 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    )
val body2SemiBold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    )

// Body3
val body3 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
    )
val body3SemiBold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
    )

// Body4
val body4 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    )
val body4SemiBold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
    )
val body4Bold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    )

// Body5
val body5 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
    )
val body5SemiBold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
    )

// Body6
val body6 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    )
val body6SemiBold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
    )

// Body7
val body7 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 9.sp,
    )
val body7Bold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 9.sp,
    )

// Body8
val body8 =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
    )
val body8SemiBold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 8.sp,
    )

val notosanskr =
    FontFamily(
        Font(R.font.notosanskr_black, FontWeight.Black, FontStyle.Normal),
        Font(R.font.notosanskr_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.notosanskr_light, FontWeight.Light, FontStyle.Normal),
        Font(R.font.notosanskr_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
        Font(R.font.notosanskr_extralight, FontWeight.ExtraLight, FontStyle.Normal),
        Font(R.font.notosanskr_medium, FontWeight.Medium, FontStyle.Normal),
        Font(R.font.notosanskr_regular, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.notosanskr_semibold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.notosanskr_thin, FontWeight.Thin, FontStyle.Normal),
    )
