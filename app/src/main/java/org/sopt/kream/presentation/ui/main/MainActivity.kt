package org.sopt.kream.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import org.sopt.kream.R
import org.sopt.kream.databinding.ActivityMainBinding
import org.sopt.kream.util.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.findNavController()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.recommend_fragment || destination.id == R.id.release_fragment) {
                binding.bnvMain.visibility = View.VISIBLE
            } else if (destination.id == R.id.search_fragment || destination.id == R.id.product_detail_fragment) {
                binding.bnvMain.visibility = View.GONE
            }
        }
    }
}
