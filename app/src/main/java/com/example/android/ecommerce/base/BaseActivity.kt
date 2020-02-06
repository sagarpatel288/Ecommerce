package com.example.android.ecommerce.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.android.ecommerce.BR

/**
 * 2/5/2020
 * Our class is parameterized class and we have set constraints for accepting generics.
 *
 * @see <a href="https://kotlinlang.org/docs/tutorials/kotlin-for-py/generics.html">Kotlin Generics</a>
 * @author srdpatel
 * @since 1.0
 */
abstract class BaseActivity<VDB : ViewDataBinding, BVM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    abstract val viewModel: BVM
    private lateinit var dataBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutResId)
        dataBinding.lifecycleOwner = this
        dataBinding.setVariable(BR.viewModel, viewModel)
        dataBinding(dataBinding)
        otherStuffs()
    }

    abstract fun dataBinding(dataBinding: ViewDataBinding)

    abstract fun otherStuffs()
}