package com.mhmdbh.portfolio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.img_maximize_64x


data class OnlineAccountModel(
    val title: String,
    val type: OnlineAccountType
) {
    companion object {
        val default = listOf(
            OnlineAccountModel(
                title = "Email",
                type = OnlineAccountType.Mail("mohmd.h.bh@gmail.com")
            ),
            OnlineAccountModel(
                title = "LinkedIn",
                type = OnlineAccountType.Link("https://linkedin.com/in/mohmd-h-bh")
            ),
            OnlineAccountModel(
                title = "GitHub",
                type = OnlineAccountType.Link("https://github.com/Mohmd-H-BH")
            ),
        )
    }
}

sealed class OnlineAccountType() {
    data class Mail(val email: String) : OnlineAccountType()
    data class Link(val link: String) : OnlineAccountType()
}

fun String.removeHttps() =
    this.replace("https://","", ignoreCase = true)
    //this.substring(this.indexOf("https://"), this.length)


@Composable
fun OnlineAccountElement(
    modifier: Modifier = Modifier,
    title: String,
    type: OnlineAccountType,
    onClick: (OnlineAccountType) -> Unit
) {

    val value: String by remember {
        mutableStateOf(
            when (type) {
                is OnlineAccountType.Link -> type.link.removeHttps()
                is OnlineAccountType.Mail -> type.email
            }
        )
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            modifier = Modifier,
            text = "$title:",
            //style = MaterialTheme3.typography.body1,
            color = MaterialTheme.colorScheme.tertiary,
            fontWeight = FontWeight.Normal
        )

        Text(
            modifier = Modifier
                .clickable {
                    onClick(type)
                },
            text = value,
            //style = MaterialTheme3.typography.button,
            color = Color.White,
            fontWeight = FontWeight.Normal
        )

        Icon(
            modifier = Modifier
                .size(16.dp)
                .clickable {
                    onClick(type)
                },
            painter = painterResource(Res.drawable.img_maximize_64x),
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = ""
        )
    }
}