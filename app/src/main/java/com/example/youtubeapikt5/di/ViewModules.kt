package com.example.youtubeapikt5.di

import com.example.youtubeapikt5.ui.PlayListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModels: Module = module {

    viewModel { PlayListViewModel(get()) }

}