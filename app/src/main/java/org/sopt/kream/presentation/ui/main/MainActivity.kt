package org.sopt.kream.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.sopt.kream.R
import org.sopt.kream.databinding.ActivityMainBinding
import org.sopt.kream.util.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBottomNavigation()
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
}
