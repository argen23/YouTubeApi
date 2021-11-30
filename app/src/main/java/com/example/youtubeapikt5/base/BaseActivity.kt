package com.example.youtubeapikt5.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected lateinit var viewBinding : VB

    protected abstract fun inflateViewBinding() :VB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewBinding = inflateViewBinding()
        setContentView(viewBinding.root)
        checkInternet()
        setUi()
        setupLiveData()
        setupClickListener()
    }

    abstract fun setupClickListener()

    abstract fun setUi()

    abstract fun checkInternet()

    abstract fun setupLiveData()

}