package br.com.devhernand.starwars.view.widget

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.GridLayoutAnimationController

/**
 * Created by Hernand on 31/12/2017.
 */
class GridRecyclerView : RecyclerView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun setLayoutManager(layout: RecyclerView.LayoutManager) {
        if (layout is GridLayoutManager) {
            super.setLayoutManager(layout)
        } else {
            throw ClassCastException("You must use GridLayoutManager with GridRecyclerView.")
        }
    }

    override fun attachLayoutAnimationParameters(child: View, params: ViewGroup.LayoutParams, index: Int, count: Int) {

        if (adapter != null && layoutManager is GridLayoutManager) {

            var animationParams: GridLayoutAnimationController.AnimationParameters? = null

            if (params.layoutAnimationParameters == null) {
                animationParams = GridLayoutAnimationController.AnimationParameters()
                params.layoutAnimationParameters = animationParams
            }else{
                animationParams = params.layoutAnimationParameters as GridLayoutAnimationController.AnimationParameters?
            }

            val columns = (layoutManager as GridLayoutManager).spanCount

            animationParams?.apply {
                animationParams.count = count
                animationParams.index = index
                animationParams.columnsCount = columns
                animationParams.rowsCount = count / columns

                val invertedIndex = count - 1 - index
                animationParams.column = columns - 1 - invertedIndex % columns
                animationParams.row = animationParams.rowsCount - 1 - invertedIndex / columns
            }

        } else {
            super.attachLayoutAnimationParameters(child, params, index, count)
        }
    }
}