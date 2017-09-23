package com.example.fetchgitsample.ViewModel

import com.example.fetchgitsample.data.OnDataReadyCallback
import com.example.fetchgitsample.data.RepoData

class RepoViewModel {
    var repoData: RepoData = RepoData()
    var text: String = ""
    var isLoading: Boolean = false

    val onDataReadyCallback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            text = data
        }
    }

    fun refreshh() {
        repoData.refreshData(onDataReadyCallback)
    }
}