package com.example.fetchgitsample.ViewModel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.fetchgitsample.data.OnDataReadyCallback
import com.example.fetchgitsample.data.OnRepositorReadyCallback
import com.example.fetchgitsample.data.RepoData
import com.example.fetchgitsample.models.Repository

class RepoViewModel :  ViewModel() {
    var repoData: RepoData = RepoData()
    val text = ObservableField("Existing Text")
    val isLoading = ObservableField(false)
    var repositories = ArrayList<Repository>()

    fun refresh() {
        isLoading.set(true)
        repoData.refreshData(object : OnDataReadyCallback{
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }

    fun getRepositories() {
        isLoading.set(true)
        repoData.getRepositories(object : OnRepositorReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories = data
            }
        })
    }
}