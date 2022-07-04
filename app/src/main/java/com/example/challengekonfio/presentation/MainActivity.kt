package com.example.challengekonfio.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.challengekonfio.R
import com.example.challengekonfio.databinding.ActivityMainBinding
import com.example.challengekonfio.presentation.ui.fragments.DogsFragment
import com.example.challengekonfio.presentation.ui.fragments.DogsFragment.Companion.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToFragmentDogs()
    }

    private fun goToFragmentDogs(){
        navigationFragment(DogsFragment(),TAG)
    }

    private fun navigationFragment(fragment:Fragment,tag: String){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.layout_root, fragment)
            .commit()
    }


    override fun onBackPressed() { finish() }
}