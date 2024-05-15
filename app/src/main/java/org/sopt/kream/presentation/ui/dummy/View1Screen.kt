package org.sopt.kream.presentation.ui.dummy

import android.widget.HorizontalScrollView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.kream.R
import org.sopt.kream.theme.Black01
import org.sopt.kream.theme.head1Bold

@Composable
fun View1Screen(dummyViewModel: DummyViewModel) {
    var editText by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            Column (modifier = Modifier.fillMaxWidth()){
                Row (modifier = Modifier.fillMaxWidth()){
                    TextField(value = editText,
                        onValueChange = { editText = it },
                        label = { Text(text = stringResource(id = R.string.bar_search_label)) }
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_topappbar_bell_28),
                        contentDescription =""
                    )
                }

            }
        }
    ) { innerPadding ->
        View1Content(Modifier.padding(innerPadding))
    }
}

@Composable
fun View1Content(modifier: Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "View1 Screen",
            style = head1Bold,
            color = Black01
        )
    }
}

@Preview
@Composable
fun View1Preview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "View1 Screen",
            style = head1Bold,
            color = Black01
        )
    }
}