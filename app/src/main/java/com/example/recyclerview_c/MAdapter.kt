package com.example.recyclerview_c

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

// 继承于Adapter时，Adapter要传入一个继承于ViewHolder或是继承于ViewHolder的子类
// 但是由于ViewHolder也是一个抽象类，所以也要写一个继承于它的子类
class MAdapter : RecyclerView.Adapter<MAdapter.MyViewHolder>() {
//    点击回调
    var callBack:((Int) -> Unit)? = null

//    接收MainActivity在创建Adapter时传递过来的数据
    lateinit var data: MutableList<Int>

//    继承于Adapter是必须实现的三个抽象方法
//    创建ViewHolder，并解析RecycleView的子列表对应的xml布局文件，用以确定自己item的显示样式
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//    xml布局解析
        var inflater = LayoutInflater.from(parent.context)
        var itemView = inflater.inflate(R.layout.fot_item, parent, false)

        return MyViewHolder(itemView)
    }
//    获取子项的个数
    override fun getItemCount(): Int {
        return data.size
    }

    //    将视图和数据进行绑定（getItemCount只会调用一次，onCreateViewHolder当创建的ViewHolder数量足够时，也
//     不会再调用。但是，只要RecycleView在滚动，显示的数据在更新，onBindViewHolder就会一直调用）
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.icon.setImageResource((data[position]))

        holder.itemView.setOnClickListener(){
            callBack?.let {
                it(position)
            }
        }
    }

//    在继承于ViewHolder时，系统默认一定要出人一个参数：itemView，ViewHolder管理的View视图
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        获取视图
        var icon = itemView.findViewById<ImageView>(R.id.item_icon)
    }
}