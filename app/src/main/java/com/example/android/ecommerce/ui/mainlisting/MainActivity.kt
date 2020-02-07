package com.example.android.ecommerce.ui.mainlisting

import android.content.Intent
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.ecommerce.R
import com.example.android.ecommerce.base.BaseActivity
import com.example.android.ecommerce.databinding.ActivityMainBinding
import com.example.android.ecommerce.listeners.Callbacks
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.viewmodels.ActivityMainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, ActivityMainViewModel> (R.layout.activity_main),
    Callbacks.Callback {

    private var dataBinding: ActivityMainBinding? = null

    override val viewModel: ActivityMainViewModel by viewModel()
    private var categoryListAdapter: CategoryListAdapter? = null
    private val layoutManager = LinearLayoutManager(this)


    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as? ActivityMainBinding
    }

    override fun otherStuffs() {
        setRecyclerView()
        loadData()
    }

    private fun loadData() {
        viewModel.getParentCategories(this)?.observe(this, Observer { renderListData(it) })
    }

    private fun renderListData(mutableCategoryList: ArrayList<Category>?) {
        if (mutableCategoryList != null){
            categoryListAdapter?.setList(mutableCategoryList)
        }
    }

    private fun setRecyclerView() {
        categoryListAdapter = CategoryListAdapter(this, mutableListOf(), this)
        dataBinding?.rvCategoryList?.layoutManager = layoutManager
        dataBinding?.rvCategoryList?.adapter = categoryListAdapter
    }

    override fun onEventCallBack(intent: Intent) {

    }
}
