package org.sopt.kream.util.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.kream.R
import org.sopt.kream.theme.Black09
import org.sopt.kream.theme.Gray06
import org.sopt.kream.theme.KreamAndroidTheme
import org.sopt.kream.theme.body5Regular

@Composable
fun KreamTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    value: String = "",
    onValueChange: (String) -> Unit = { _ -> }
) {
    Row(
        modifier = modifier
            .background(color = Gray06, shape = RoundedCornerShape(9.dp))
            .padding(horizontal = 9.dp, vertical = 7.dp)
            .fillMaxWidth()
    ) {
        BasicTextField(
            modifier = Modifier.weight(1f),
            value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Color.Black),
            singleLine = true,
            textStyle = body5Regular,
            decorationBox = { innerTextField ->
                innerTextField()
                if (value.isEmpty()) {
                    Text(
                        color = Black09,
                        style = body5Regular,
                        text = placeholder
                    )
                }
            }
        )
        if (value.isNotEmpty()) {
            Spacer(
                Modifier.width(4.dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_delete_24),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun KreamTextFieldPreview() {
    KreamAndroidTheme {
        KreamTextField(
            placeholder = "브랜드, 상품, 프로필, 태그 등"
        )
    }
}