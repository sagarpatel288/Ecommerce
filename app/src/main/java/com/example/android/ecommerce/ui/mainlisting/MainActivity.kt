package com.example.android.ecommerce.ui.mainlisting

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.ecommerce.R
import com.example.android.ecommerce.base.BaseActivity
import com.example.android.ecommerce.databinding.ActivityMainBinding
import com.example.android.ecommerce.listeners.Callbacks
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.model.Detail
import com.example.android.ecommerce.model.Product
import com.example.android.ecommerce.model.Variant
import com.example.android.ecommerce.ui.mainlisting.detail.DetailActivity
import com.example.android.ecommerce.utils.IntentUtils
import com.example.android.ecommerce.viewmodels.ActivityMainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity :
    BaseActivity<ActivityMainBinding, ActivityMainViewModel>(R.layout.activity_main),
    Callbacks.Callback {

    private var dataBinding: ActivityMainBinding? = null
    override val viewModel: ActivityMainViewModel by viewModel()
    private var categoryListAdapter: CategoryListAdapter? = null
    private val detail = Detail(null, null, null)

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as? ActivityMainBinding
    }

    override fun otherStuffs() {
        setRecyclerView(dataBinding?.rvCategoryList, mutableListOf())
        loadData()
    }

    private fun loadData() {
        viewModel.getParentCategories(this).observe(this, Observer { renderListData(it) })
    }

    private fun renderListData(mutableCategoryList: List<Category>?) {
        if (mutableCategoryList != null) {
            categoryListAdapter?.setList(mutableCategoryList)
        }
    }

    private fun setRecyclerView(recyclerView: RecyclerView?, mList: List<Category>) {
        categoryListAdapter = CategoryListAdapter(this, mList, this)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = categoryListAdapter
    }

    private fun setProductRecyclerView(recyclerView: RecyclerView?, mList: List<Product?>?) {
        val productListAdapter = ProductListAdapter(this, mList, this)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = productListAdapter
    }

    private fun setVariantRecyclerView(recyclerView: RecyclerView?, mList: List<Variant?>?) {
        val variantListAdapter = VariantListAdapter(this, mList, this)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = variantListAdapter
    }

    override fun onEventCallBack(intent: Intent) {
        if (IntentUtils.hasParcel(intent)) {
            if (IntentUtils.getParcel<Category>(intent) is Category) {
                val category: Category = IntentUtils.getParcel<Category>(intent) as Category
                detail.category = category
                Toast.makeText(this, category.name, Toast.LENGTH_SHORT).show()
                if (!category.childCategories.isNullOrEmpty()) {
                    // comment by srdpatel: 2/7/2020 There are still some child categories
                    showBottomSheetDialog(
                        this,
                        LayoutInflater.from(this).inflate(R.layout.bottom_sheet_dialog, null),
                        viewModel.getCategoriesByIds(category.childCategories as ArrayList<Long>)
                    )
                } else {
                    showProductDialog(
                        this,
                        LayoutInflater.from(this).inflate(R.layout.product_sheet_dialog, null),
                        viewModel.getProductsByParentId(category.id)
                    )
                }
            } else if (IntentUtils.getParcel<Product>(intent) is Product) {
                val product: Product = IntentUtils.getParcel<Product>(intent) as Product
                Toast.makeText(this, product.name, Toast.LENGTH_SHORT).show()
                detail.product = product
                showVariantDialog(
                    this,
                    LayoutInflater.from(this).inflate(R.layout.variant_sheet_dialog, null),
                    product.variants
                )
            } else if (IntentUtils.getParcel<Variant>(intent) is Variant){
                val variant: Variant = IntentUtils.getParcel<Variant>(intent) as Variant
                Toast.makeText(this, "" + variant.size, Toast.LENGTH_SHORT).show()
                detail.variant = variant
                startActivity(IntentUtils.getIntentWithParcel(this, detail, DetailActivity::class.java))
            }
        }
    }

    fun showBottomSheetDialog(context: Context, view: View, mList: List<Category>) {
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(view)
        setRecyclerView(view.findViewById(R.id.rv_category_list), mList)
        bottomSheetDialog.show()
    }

    fun showProductDialog(context: Context, view: View, mList: List<Product?>?) {
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(view)
        setProductRecyclerView(view.findViewById(R.id.rv_category_list), mList)
        bottomSheetDialog.show()
    }

    fun showVariantDialog(context: Context, view: View, mList: List<Variant?>?) {
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(view)
        setVariantRecyclerView(view.findViewById(R.id.rv_category_list), mList)
        bottomSheetDialog.show()
    }
}
