package com.example.android.ecommerce.di.viewmodules

import com.example.android.ecommerce.viewmodels.ActivityDetailViewModel
import com.example.android.ecommerce.viewmodels.ActivityMainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {

    viewModel {
        ActivityMainViewModel()
    }

    viewModel {
        ActivityDetailViewModel()
    }
}