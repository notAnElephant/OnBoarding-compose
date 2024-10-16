package com.bls.compose_onboarding.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bls.compose_onboarding.indicator.Indicators

/**
 * BOTTOM SECTION
 */
@Composable
fun BottomSection(
    size: Int,
    index: Int,
    selectedIndicatorColor: Color,
    unSelectedIndicatorColor: Color,
    indicatorHeight: Dp,
    spaceBetweenIndicators: Dp,
    onNextClicked: () -> Unit,
    nextButtonShape: Shape,
    nextButtonBackgroundColor: Color,
    nextButtonIconColor: Color,
    showNextOnLastPageOnly: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Indicators(
            size = size,
            index = index,
            selectedIndicatorColor = selectedIndicatorColor,
            unSelectedIndicatorColor = unSelectedIndicatorColor,
            indicatorHeight = indicatorHeight,
            spaceBetweenIndicators = spaceBetweenIndicators,
        )

        if(!showNextOnLastPageOnly || index == size - 1) {
            FloatingActionButton(
                onClick = onNextClicked,
                shape = nextButtonShape,
                containerColor = nextButtonBackgroundColor,
                contentColor = nextButtonIconColor,
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
        else{
            Box(modifier = Modifier.size(56.dp))
        }
    }
}