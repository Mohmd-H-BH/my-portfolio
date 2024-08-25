package com.mhmdbh.portfolio

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DpSize(val width: Dp, val height: Dp) {
    companion object {
        val Zero = DpSize(0.dp, 0.dp)
    }
}