package com.example.youtubeapikt5.ui.noInternet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubeapikt5.databinding.NoInternetCheckBinding
import com.example.youtubeapikt5.utils.NetworkCheck

class NoInternetActivity : AppCompatActivity() {

    private lateinit var networkCheck: NetworkCheck
    private lateinit var binding: NoInternetCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NoInternetCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkCheck = NetworkCheck(this)
        binding.btnTryAgain.setOnClickListener {
            if (isNetworkAvailable()) {
                finish()
            } else {
                Toast.makeText(baseContext, "Please, connect to wifi", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun isNetworkAvailable(): Boolean {
        var isAvailable = false
        networkCheck.observe(this, {
            isAvailable = it
        })

        return isAvailable
    }


}

