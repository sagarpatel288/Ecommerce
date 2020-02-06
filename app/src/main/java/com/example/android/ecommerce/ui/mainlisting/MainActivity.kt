package com.example.android.ecommerce.ui.mainlisting

import androidx.databinding.ViewDataBinding
import com.example.android.ecommerce.R
import com.example.android.ecommerce.base.BaseActivity
import com.example.android.ecommerce.databinding.ActivityMainBinding
import com.example.android.ecommerce.viewmodels.ActivityMainViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, ActivityMainViewModel> (R.layout.activity_main) {

    private var dataBinding: ActivityMainBinding? = null

    override val viewModel: ActivityMainViewModel by viewModel()


    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as? ActivityMainBinding
    }

    override fun otherStuffs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
