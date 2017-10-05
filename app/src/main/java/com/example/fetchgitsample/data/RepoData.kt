package com.example.fetchgitsample.data

import android.os.Handler
import com.example.fetchgitsample.models.Repository

class RepoData {
    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("New Data") }, 2000)
    }

    fun getRepositories(onRepositorReadyCallback: OnRepositorReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner A", 10, false))
        arrayList.add(Repository("Second", "Owner B", 20, true))
        arrayList.add(Repository("Third", "Owner C", 30, false))

        Handler().postDelayed({ onRepositorReadyCallback.onDataReady(arrayList) }, 2000)
    }

}

interface OnDataReadyCallback {
    fun onDataReady(data: String) {}
}

interface OnRepositorReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}

