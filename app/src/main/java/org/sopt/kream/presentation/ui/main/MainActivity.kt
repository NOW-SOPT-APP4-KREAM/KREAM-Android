package org.sopt.kream.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.sopt.kream.R
import org.sopt.kream.databinding.ActivityMainBinding
import org.sopt.kream.util.base.BindingActivity
import org.sopt.kream.util.component.KreamTab
import org.sopt.kream.util.component.KreamTabBar
import org.sopt.kream.util.component.KreamTextField

class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initTop()
        initBottomNavigation()
    }

    private fun initTop() {
        binding.cvMainTop.setContent {
            SetTopLayout()
        }
    }

    @Composable
    private fun SetTopLayout() {
        var selectedTabPosition by remember { mutableIntStateOf(DEFAULT_INDEX) }
        var searchText by remember {
            mutableStateOf("")
        }

        val items = listOf(
            stringResource(R.string.top_bar_main_recommend),
            stringResource(R.string.top_bar_main_ranking),
            stringResource(R.string.top_bar_main_information),
            stringResource(R.string.top_bar_main_luxury),
            stringResource(R.string.top_bar_main_male),
            stringResource(R.string.top_bar_main_female),
            stringResource(R.string.top_bar_main_found),
            stringResource(R.string.top_bar_main_event)
        )

        val selectableItems = listOf(
            stringResource(R.string.top_bar_main_recommend),
            stringResource(R.string.top_bar_main_information)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 11.dp)
            ) {
                KreamTextField(
                    modifier = Modifier.weight(1f).padding(end = 14.dp),
                    placeholder = stringResource(id = R.string.search_bar_label),
                    value = searchText,
                    onValueChange = { searchText = it }
                )
                Image(
                    painter = painterResource(R.drawable.ic_topappbar_bell_28),
                    contentDescription = null
                )
            }

            KreamTabBar(selectedTabPosition = selectedTabPosition) {
                KreamTab(text = stringResource(R.string.top_bar_main_md), textColor = org.sopt.kream.theme.PinkColor, position = FIRST_INDEX, selected = FIRST_INDEX == selectedTabPosition)

                items.forEachIndexed { index, text ->
                    (index + 1).let { tabIndex ->
                        KreamTab(text = text, position = tabIndex, selected = tabIndex == selectedTabPosition) {
                            if (text in selectableItems) selectedTabPosition = tabIndex
                        }
                    }
                }
            }
        }
    }

    private fun initBottomNavigation() {
        val navController = (supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment).navController
        binding.bnvMain.setupWithNavController(navController)

        setComponentVisibility(navController)
    }

    private fun setComponentVisibility(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.apply {
                if (destination.id in
                    listOf(
                        R.id.recommend_fragment,
                        R.id.release_fragment,
                    )
                ) {
                    cvMainTop.visibility = View.VISIBLE
                    bnvMain.visibility = View.VISIBLE
                    viewMain.visibility = View.VISIBLE
                } else {
                    cvMainTop.visibility = View.GONE
                    bnvMain.visibility = View.GONE
                    viewMain.visibility = View.GONE
                }
            }
        }
    }

    companion object {
        const val DEFAULT_INDEX = 1
        const val FIRST_INDEX = 0
    }
}
