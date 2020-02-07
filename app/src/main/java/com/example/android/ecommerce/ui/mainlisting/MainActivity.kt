package com.example.android.ecommerce.ui.mainlisting

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.ecommerce.R
import com.example.android.ecommerce.base.BaseActivity
import com.example.android.ecommerce.databinding.ActivityMainBinding
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.model.Ranking
import com.example.android.ecommerce.model.Response
import com.example.android.ecommerce.utils.FileUtils
import com.example.android.ecommerce.utils.Utils
import com.example.android.ecommerce.viewmodels.ActivityMainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, ActivityMainViewModel> (R.layout.activity_main) {

    private var dataBinding: ActivityMainBinding? = null

    override val viewModel: ActivityMainViewModel by viewModel()
    private val categoryListAdapter: CategoryListAdapter? = null
    private val linearLayoutManager = LinearLayoutManager(this)


    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as? ActivityMainBinding
    }

    override fun otherStuffs() {
        setRecyclerView()
        loadData()
        val jsonString: String = FileUtils.getJsonFromAsset(this, "ecommerce.json")
        val response : Response = Utils.toObject(jsonString, Response(), Response::class.java)
        var categoryList: List<Category?>? = response.categories
        var rankingList: List<Ranking?>? = response.rankings

    }

    private fun loadData() {

    }

    private fun setRecyclerView() {
        
    }
}
