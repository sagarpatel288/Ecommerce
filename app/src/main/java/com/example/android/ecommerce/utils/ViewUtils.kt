package com.example.android.ecommerce.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog

class ViewUtils {
    companion object {

        @JvmStatic
        fun showBottomSheetDialog(context: Context, view: View): BottomSheetDialog {
            val bottomSheetDialog = BottomSheetDialog(context)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
            return bottomSheetDialog
        }

        @JvmStatic
        fun getView(context: Context, resLayId: Int): View {
            return LayoutInflater.from(context).inflate(resLayId, null)
        }
    }
}