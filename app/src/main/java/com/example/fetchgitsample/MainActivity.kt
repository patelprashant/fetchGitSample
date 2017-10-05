package com.example.fetchgitsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.fetchgitsample.ViewModel.RepoViewModel
import com.example.fetchgitsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //    private var repository = Repository("This is Sample Android App", "Prashant Patel", 1000, true)
    private var repoViewModel = RepoViewModel ()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.repoViewModel = repoViewModel
        binding.executePendingBindings()

//        Handler().postDelayed({
//            repository.repositoryName = "This is Totally New"
//        }, 2000)
//        binding.apply {
//            repositoryName.text = "This is Sample Android App"
//            repositoryOwner.text = "Prashant Patel"
//            numberOfStars.text = "10 stars"
//        }
    }
}
