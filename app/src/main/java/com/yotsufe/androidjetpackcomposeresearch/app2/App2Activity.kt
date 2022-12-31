package com.yotsufe.androidjetpackcomposeresearch.app2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent

class App2Activity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, App2Activity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
