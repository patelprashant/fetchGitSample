package com.example.fetchgitsample.data

import android.os.Handler

class RepoData() {
    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({onDataReadyCallback.onDataReady("New Data")}, 2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data: String) {}
}
