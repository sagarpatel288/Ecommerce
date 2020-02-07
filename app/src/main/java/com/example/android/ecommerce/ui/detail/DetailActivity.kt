package com.example.android.ecommerce.ui.detail

import androidx.databinding.ViewDataBinding
import com.example.android.ecommerce.R
import com.example.android.ecommerce.base.BaseActivity
import com.example.android.ecommerce.databinding.ActivityDetailBinding
import com.example.android.ecommerce.model.Detail
import com.example.android.ecommerce.utils.IntentUtils
import com.example.android.ecommerce.viewmodels.ActivityDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding, ActivityDetailViewModel>(R.layout.activity_detail) {

    private var dataBinding: ActivityDetailBinding? = null

    override val viewModel: ActivityDetailViewModel by viewModel()

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as? ActivityDetailBinding
    }

    override fun otherStuffs() {
        if (IntentUtils.hasParcel(intent)){
            if (IntentUtils.getParcel<Detail>(intent) is Detail){
                val detail = IntentUtils.getParcel<Detail>(intent)
                setData(detail)
            }
        }
    }

    private fun setData(detail: Detail?) {
        dataBinding?.itemTvCategoryValue?.text = detail?.category?.name
        dataBinding?.itemTvProductValue?.text = detail?.product?.name
        dataBinding?.includeVariant?.itemTvColorValue?.text = detail?.variant?.color
        dataBinding?.includeVariant?.itemTvSizeValue?.text = detail?.variant?.size.toString()
        dataBinding?.includeVariant?.itemTvPriceValue?.text = detail?.variant?.price.toString()
    }
}
