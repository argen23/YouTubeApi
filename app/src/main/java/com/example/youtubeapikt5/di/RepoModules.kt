package com.example.youtubeapikt5.di

import com.example.youtubeapikt5.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules : Module = module {
single { Repository() }

}