package org.sopt.kream.presentation.ui.dummy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.sopt.kream.theme.Gray06
import org.sopt.kream.theme.head1Bold

@Composable
fun view1Screen(dummyViewModel: DummyViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "View1 Screen",
            style = head1Bold,
            color = Gray06,
        )
    }
}
