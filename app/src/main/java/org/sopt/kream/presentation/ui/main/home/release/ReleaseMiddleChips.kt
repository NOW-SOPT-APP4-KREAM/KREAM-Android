package org.sopt.kream.presentation.ui.main.home.release

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.kream.R
import org.sopt.kream.theme.body5Regular

@Composable
fun ReleaseMiddleChips() {
    val shoes =
        listOf(
            stringResource(R.string.release_chip_shoes_list_today),
            stringResource(R.string.release_chip_shoes_list_Nike),
            stringResource(R.string.release_chip_shoes_list_Adidas),
            stringResource(R.string.release_chip_shoes_list_Asics),
            stringResource(R.string.release_chip_shoes_list_NewBalance),
            stringResource(R.string.release_chip_shoes_list_Jordan),
            stringResource(R.string.release_chip_shoes_list_converse),
        )

    var selectedIndex by remember { mutableIntStateOf(0) } // Track selected index

    Column {
        LazyRow(
            modifier =
            Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .background(Color.White),
        ) {
            items(shoes.size) { index ->
                val isSelected = index == selectedIndex
                val backgroundColor = if (isSelected) colorResource(id = R.color.red01) else colorResource(id = R.color.gray05)
                val textColor = if (isSelected) colorResource(id = R.color.red02) else Color.Black // Update to your selected and default text color

                if (index == 0) {
                    Row(
                        modifier =
                        Modifier
                            .padding(top = 10.dp)
                            .padding(start = 14.dp)
                            .padding(end = 6.dp)
                            .clickable { selectedIndex = 0 },
                    ) {
                        Spacer(modifier = Modifier.width(4.dp))

                        CustomShoesText(
                            text = shoes[index],
                            textColor = textColor,
                            backgroundColor = backgroundColor,
                        )

                        Box(
                            modifier =
                            Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 9.dp)
                                .width(1.dp)
                                .height(23.dp)
                                .background(colorResource(id = R.color.gray04)),
                        )
                    }
                } else {
                    Column(
                        modifier =
                        Modifier
                            .padding(top = 10.dp)
                            .padding(bottom = 10.dp)
                            .padding(end = 6.dp)
                            .clickable { selectedIndex = index },
                    ) {
                        Text(
                            text = shoes[index],
                            style = body5Regular.copy(color = textColor),
                            modifier =
                            Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(backgroundColor)
                                .padding(10.dp),
                        )
                    }
                }
            }
        }
    }
}