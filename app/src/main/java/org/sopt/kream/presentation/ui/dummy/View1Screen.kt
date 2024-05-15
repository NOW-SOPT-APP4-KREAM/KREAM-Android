package org.sopt.kream.presentation.ui.dummy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import kotlinx.coroutines.launch
import org.sopt.kream.R
import org.sopt.kream.theme.Black01
import org.sopt.kream.theme.Black02
import org.sopt.kream.theme.Black09
import org.sopt.kream.theme.Gray06
import org.sopt.kream.theme.body3SemiBold
import org.sopt.kream.theme.body5Regular
import org.sopt.kream.theme.head1Bold

val pages = listOf("추천", "랭킹", "발매정보", "럭셔리", "남성", "여성", "발견")

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun View1Screen() {
    var editText by remember {
        mutableStateOf("")
    }
    val pagerState =
        rememberPagerState {
            pages.size
        }
    Scaffold(
        topBar = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(33.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.width(14.dp))

                    BasicTextField(
                        value = editText,
                        onValueChange = { editText = it },
                        singleLine = true,
                        modifier =
                        Modifier
                            .weight(1f)
                            .size(width = 293.dp, height = 33.dp)
                            .background(color = Gray06, shape = RoundedCornerShape(9.dp)),
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier.padding(start = 7.dp),
                            ) {
                                innerTextField()
                                if (editText.isEmpty()) {
                                    Text(
                                        style = body5Regular,
                                        color = Black09,
                                        text = stringResource(id = R.string.bar_search_label),
                                    )
                                }
                            }
                        },
                    )

                    Spacer(modifier = Modifier.width(14.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_topappbar_bell_28),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                    )
                    Spacer(modifier = Modifier.width(11.dp))
                }
                CustomTabPager(pagerState, pages)
            }
        },
    ) { innerPadding ->
        View1Content(Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomTabPager(
    pagerState: PagerState,
    tabs: List<String>,
) {
    val coroutineScope = rememberCoroutineScope()
    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    modifier =
                        Modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            ,
                    color = Black02,
                    width = pages[pagerState.currentPage].length * 12.dp

                )
            },
            containerColor = Color.White,
            contentColor = Black02,
            edgePadding = 0.dp,
            modifier = Modifier.padding(0.dp),
        ) {
//            Text(text = "서재패Md", style = body3SemiBold, color = PinkColor)
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title, style = body3SemiBold) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier.width(0.dp),
                )
            }
        }
        HorizontalDivider(
            modifier =
                Modifier
                    .fillMaxWidth(),
            color = Color.LightGray,
            thickness = 1.dp,
        )

        HorizontalPager(
            state = pagerState,
        ) { page ->
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                when (page) {
                    0 -> View1Content(modifier = Modifier)
                    2 -> View2Content(modifier = Modifier)
                }
            }
        }
    }
}



@Composable
fun View1Content(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "추천",
            style = head1Bold,
            color = Black01,
        )
    }
}

@Composable
fun View2Content(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "발매정보",
            style = head1Bold,
            color = Black01,
        )
    }
}
