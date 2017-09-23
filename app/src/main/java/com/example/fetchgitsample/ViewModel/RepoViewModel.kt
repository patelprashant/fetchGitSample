package com.example.fetchgitsample.ViewModel

import android.databinding.ObservableField
import com.example.fetchgitsample.data.OnDataReadyCallback
import com.example.fetchgitsample.data.RepoData

class RepoViewModel {
    var repoData: RepoData = RepoData()
    val text = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()

    val onDataReadyCallback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            isLoading.set(false)
            text.set(data)
        }
    }

    fun refreshh() {
        isLoading.set(true)
        repoData.refreshData(onDataReadyCallback)
    }
}