package org.sopt.kream.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.sopt.kream.R
import org.sopt.kream.databinding.ActivityMainBinding
import org.sopt.kream.util.base.BindingActivity
import org.sopt.kream.util.component.KreamTab
import org.sopt.kream.util.component.KreamTabBar

class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initTabBar()
        initBottomNavigation()
    }

    private fun initTabBar() {
        binding.cvMainTabBar.setContent {
            SetKreamTabBar()
        }
    }

    @Composable
    private fun SetKreamTabBar() {
        var selectedTabPosition by remember { mutableIntStateOf(DEFAULT_INDEX) }

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

    private fun initBottomNavigation() {
        val navController = (supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment).navController
        binding.bnvMain.setupWithNavController(navController)

        setBottomNavigationVisibility(navController)
    }

    private fun setBottomNavigationVisibility(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.apply {
                if (destination.id in
                    listOf(
                        R.id.recommend_fragment,
                        R.id.release_fragment,
                    )
                ) {
                    bnvMain.visibility = View.VISIBLE
                    viewMain.visibility = View.VISIBLE
                } else {
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
