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
        )
    )

// Head
val head1Bold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
    fontSize = 18.sp
)
val head2Bold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
    fontSize = 15.sp
)

// Body1
val body1Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 17.sp
)

// Body2
val body2Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 14.sp
)
val body2SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
    fontSize = 14.sp
)

// Body3
val body3Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 13.sp
)
val body3SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
    fontSize = 13.sp
)

// Body4
val body4Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 12.sp
)
val body4SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
    fontSize = 12.sp
)
val body4Bold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
    fontSize = 12.sp
)

// Body5
val body5Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 11.sp
)
val body5SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
    fontSize = 11.sp
)

// Body6
val body6Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 10.sp
)
val body6SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
    fontSize = 10.sp
)

// Body7
val body7Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 9.sp
)
val body7Bold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
    fontSize = 9.sp
)

// Body8
val body8Regular = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
    fontSize = 8.sp
)
val body8SemiBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.notosanskr_semibold)),
    fontSize = 8.sp
)


val notosanskr = FontFamily(
    Font(R.font.notosanskr_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.notosanskr_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.notosanskr_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.notosanskr_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.notosanskr_extralight, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.notosanskr_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.notosanskr_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.notosanskr_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.notosanskr_thin, FontWeight.Thin, FontStyle.Normal)
)
