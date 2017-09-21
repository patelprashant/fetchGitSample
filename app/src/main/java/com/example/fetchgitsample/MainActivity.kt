package com.example.fetchgitsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.fetchgitsample.databinding.ActivityMainBinding
import com.example.fetchgitsample.models.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var repository = Repository("This is Sample Android App", "Prashant Patel", 1000, true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.repository = repository
        binding.executePendingBindings()

        Handler().postDelayed({
            repository.repositoryName = "This is Totally New"
        }, 2000)
//        binding.apply {
//            repositoryName.text = "This is Sample Android App"
//            repositoryOwner.text = "Prashant Patel"
//            numberOfStars.text = "10 stars"
//        }
    }
}
