package com.mhmdbh.portfolio.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.nunitoSans_10pt_bold
import portfolio.composeapp.generated.resources.nunitoSans_10pt_medium
import portfolio.composeapp.generated.resources.nunitoSans_10pt_regular

@OptIn(ExperimentalResourceApi::class)
@Composable
fun NunitoSansTypography(): Typography {
    val nunitoSans = FontFamily(
        Font(
            resource = Res.font.nunitoSans_10pt_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_regular,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_regular,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_medium,
            weight = FontWeight.Thin,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_bold,
            weight = FontWeight.Black,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_bold,
            weight = FontWeight.Black,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_bold,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.nunitoSans_10pt_medium,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        ),
    )

    return Typography(
        headlineSmall = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            fontFamily = nunitoSans
        ),
        titleLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            fontFamily = nunitoSans
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            fontFamily = nunitoSans
        ),
        bodyMedium = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            fontFamily = nunitoSans
        ),
        labelMedium = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            fontFamily = nunitoSans
        ),
    )
}
