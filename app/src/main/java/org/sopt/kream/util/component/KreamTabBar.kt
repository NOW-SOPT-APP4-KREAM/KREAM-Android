package org.sopt.kream.util.component

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.kream.R
import org.sopt.kream.theme.Black02
import org.sopt.kream.theme.Gray05
import org.sopt.kream.theme.White
import org.sopt.kream.theme.body3Regular
import org.sopt.kream.theme.body3SemiBold
import org.sopt.kream.util.modifier.noRippleClickable

enum class SubComposeID {
    INIT,
    TAB,
    INDICATOR,
}

data class TabPosition(
    val x: Dp,
    val width: Dp,
)

@Composable
fun KreamTabBar(
    indicatorColor: Color = Color.Black,
    animationSpec: AnimationSpec<Dp> = tween(durationMillis = 250, easing = FastOutSlowInEasing),
    selectedTabPosition: Int = 0,
    tabItem: @Composable () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            Modifier
                .fillMaxWidth()
                .background(color = White)
                .horizontalScroll(state = rememberScrollState()),
    ) {
        Surface(
            modifier =
                Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally),
            color = White,
        ) {
            SubcomposeLayout(
                modifier =
                    Modifier
                        .selectableGroup(),
            ) { constraints ->
                val maxItemHeight =
                    subcompose(SubComposeID.INIT, tabItem)
                        .map { it.measure(constraints) }.maxOf { it.height }

                val tabs =
                    subcompose(SubComposeID.TAB, tabItem).map {
                        it.measure(constraints)
                    }

                val tabPositions =
                    tabs.mapIndexed { index, placeable ->
                        val x = tabs.take(index).sumOf { it.width }
                        val width = placeable.width
                        TabPosition(x = x.toDp(), width = width.toDp())
                    }

                val tabRowWidth = tabs.sumOf { it.width }

                layout(tabRowWidth, maxItemHeight) {
                    subcompose(SubComposeID.INDICATOR) {
                        Box(
                            Modifier
                                .tabIndicator(tabPositions[selectedTabPosition], animationSpec)
                                .background(color = indicatorColor),
                        )
                    }.forEach {
                        it.measure(Constraints.fixed(tabRowWidth, maxItemHeight)).placeRelative(0, 0)
                    }

                    tabs.forEachIndexed { index, placeable ->
                        val x = tabs.take(index).sumOf { it.width }
                        placeable.placeRelative(x, 0)
                    }
                }
            }
        }
    }
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(Gray05)
                .height(1.dp),
    )
}

@Composable
private fun Modifier.tabIndicator(
    tabPosition: TabPosition,
    animationSpec: AnimationSpec<Dp>,
): Modifier {
    val animatedTabWidth by animateDpAsState(
        targetValue = tabPosition.width,
        animationSpec = animationSpec,
        label = "",
    )
    val animatedIndicatorOffset by animateDpAsState(
        targetValue = tabPosition.x,
        animationSpec = animationSpec,
        label = "",
    )

    return this
        .fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = animatedIndicatorOffset + 12.dp)
        .width(animatedTabWidth - 24.dp)
        .height(2.dp)
}

@Composable
fun KreamTab(
    text: String,
    textColor: Color = Black02,
    position: Int,
    selected: Boolean,
    onClick: (Int) -> Unit = {},
) {
    Text(
        text = text,
        style = if (selected) body3SemiBold else body3Regular,
        color = textColor,
        modifier =
            Modifier
                .padding(bottom = 4.dp, top = 24.dp, start = 12.dp, end = 12.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .noRippleClickable(
                    onClick = { onClick(position) },
                ),
    )
}

@Preview
@Composable
fun KreamTabBarPreview() {
    var selectedTabPosition by remember { mutableIntStateOf(0) }

    val items =
        listOf(
            stringResource(R.string.top_bar_main_recommend),
            stringResource(R.string.top_bar_main_ranking),
            stringResource(R.string.top_bar_main_information),
        )

    KreamTabBar(selectedTabPosition = selectedTabPosition) {
        items.forEachIndexed { index, text ->
            KreamTab(text = text, position = index, selected = index == selectedTabPosition) {
                selectedTabPosition = index
            }
        }
    }
}
