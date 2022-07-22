package com.example.capstorefinal

import android.app.Application
import com.example.capstorefinal.domain.remote.InetRep

class App : Application() {
    val repository: InetRep by lazy {
        InetRep()
    }
}