package com.example.recyclerview_c

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //    保存数据源的数组
    private var dataSource = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

////        配置RecycleView的显示样式：线性
//        mRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

//        //        配置RecycleView的显示样式：网格布局
//        mRecyclerView.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

//                配置RecycleView的显示样式：瀑布布局
        mRecyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

//        绑定数据
        for (i in 0..20) {
            if ((Random.nextInt()) % 2 == 0) {
                dataSource.add(R.drawable.yk2)
            } else {
                dataSource.add((R.drawable.yk3))
            }

        }

//        设置适配器（adapter）
        mRecyclerView.adapter = MAdapter().also {
            it.data = dataSource
            it.callBack = {yk ->
                Log.v("yk","被点击了 $yk")
            }
        }


//        给每一个item设置分割线
//        mRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL))

//        给每个显示的item添加边距
        mRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.set(20, 20, 20, 20)
            }
        })

//        功能2、让每个item按页显示
//        PagerSnapHelper().attachToRecyclerView(mRecyclerView)
        LinearSnapHelper().attachToRecyclerView(mRecyclerView)
    }
}
